/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.SuperPowerDao;
import com.sg.superpeoplesightings.model.SuperPower;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jstuart15
 */
@Controller
public class SuperPowerController {

    SuperPowerDao superPowerDao;

    @Inject
    public SuperPowerController(SuperPowerDao superPowerDao) {
        this.superPowerDao = superPowerDao;
    }

    @RequestMapping(value = "/displaySuperPowersPage", method = RequestMethod.GET)
    public String displaySuperPowersPage(Model model) {
        List<SuperPower> superPowerList = superPowerDao.getAllSuperPowers();
        model.addAttribute("superPowerList", superPowerList);
        return "superpowers";
    }

    @RequestMapping(value = "/createSuperPower", method = RequestMethod.POST)
    public String createSuperPower(HttpServletRequest request) {
        SuperPower superPower = new SuperPower();
        superPower.setDescription(request.getParameter("description"));
        superPowerDao.addSuperPower(superPower);

        //redirect to the Super Humans page to reload it
        return "redirect:displaySuperPeoplePage";
    }

    @RequestMapping(value = "/deleteSuperPower", method = RequestMethod.GET)
    public String deleteSuperPower(HttpServletRequest request) {
        String superPowerIdParameter = request.getParameter("superPowerId");
        int superPowerId = Integer.parseInt(superPowerIdParameter);
        superPowerDao.deleteSuperPower(superPowerId);
        return "redirect:displaySuperPowersPage";
    }

}
