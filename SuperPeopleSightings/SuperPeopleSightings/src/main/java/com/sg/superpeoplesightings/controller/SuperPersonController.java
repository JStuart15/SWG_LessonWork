/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.SuperPersonDao;
import com.sg.superpeoplesightings.dao.SuperPowerDao;
import com.sg.superpeoplesightings.model.SuperPerson;
import com.sg.superpeoplesightings.model.SuperPower;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jstuart15
 */
@Controller
public class SuperPersonController {

    SuperPersonDao superPersonDao;
    SuperPowerDao superPowerDao;

    @Inject
    public SuperPersonController(SuperPersonDao orgDao, SuperPowerDao superPowerDao) {
        this.superPersonDao = orgDao;
        this.superPowerDao = superPowerDao;
    }

    @RequestMapping(value = "/displaySuperPersonsPage", method = RequestMethod.GET)
    public String displaySuperPersonsPage(Model model) {
        List<SuperPerson> superPersonList = superPersonDao.getAllSuperPeople();
        model.addAttribute("superPersonList", superPersonList);
        return "superPersons";
    }

    @RequestMapping(value = "/displaySuperPersonDetails", method = RequestMethod.GET)
    public String displaySuperPersonDetails(HttpServletRequest request, Model model) {
        String superPersonIdParameter = request.getParameter("superPersonId");
        int superPersonId = Integer.parseInt(superPersonIdParameter);
        SuperPerson superPerson = superPersonDao.getSuperPersonById(superPersonId);
        model.addAttribute("superPerson", superPerson);
        return "superPersonDetails";
    }

    @RequestMapping(value = "/createSuperPerson", method = RequestMethod.POST)
    public String createSuperPerson(HttpServletRequest request) {
        SuperPerson superPerson = new SuperPerson();
        SuperPower superPower = new SuperPower();
        superPerson.setName(request.getParameter("name"));
        superPerson.setDescription(request.getParameter("description"));
        superPerson.setSuperPower(request.getParameter("street"));


        superPersonDao.addSuperPerson(superPerson);

        //redirect to the displaySuperPersons page to reload it
        return "redirect:displaySuperPersonsPage";
    }

    @RequestMapping(value = "/deleteSuperPerson", method = RequestMethod.GET)
    public String deleteSuperPerson(HttpServletRequest request) {
        String superPersonIdParameter = request.getParameter("superPersonId");
        int superPersonId = Integer.parseInt(superPersonIdParameter);
        superPersonDao.deleteSuperPerson(superPersonId);
        return "redirect:displaySuperPersonsPage";
    }

    @RequestMapping(value = "/editSuperPerson", method = RequestMethod.POST)
    public String editSuperPerson(@Valid @ModelAttribute("superPerson") SuperPerson superPerson,
            BindingResult result) {
        //@todo - add validations to the superPerson object.
        if (result.hasErrors()) {
            return "editSuperPersonForm";
        }

        superPersonDao.updateSuperPerson(superPerson);
        return "redirect:displaySuperPersonsPage";
    }

    @RequestMapping(value = "/displayEditSuperPersonForm", method = RequestMethod.GET)
    public String displayEditSuperPersonForm(HttpServletRequest request, Model model) {
        String superPersonIdParameter = request.getParameter("superPersonId");
        int superPersonId = Integer.parseInt(superPersonIdParameter);
        SuperPerson superPerson = superPersonDao.getSuperPersonById(superPersonId);
        model.addAttribute("superPerson", superPerson);
        return "editSuperPersonForm";
    }
}
