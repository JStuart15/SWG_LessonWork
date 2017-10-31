/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.SightingDao;
import com.sg.superpeoplesightings.dao.SuperPersonDao;
import com.sg.superpeoplesightings.model.Sighting;
import com.sg.superpeoplesightings.model.SuperPerson;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jstuart15
 */
@Controller
public class HomeController {

    SightingDao sightingDao;
    SuperPersonDao superPersonDao;

    @Inject
    public HomeController(SightingDao sightingDao,
            SuperPersonDao superPersonDao) {
        this.sightingDao = sightingDao;
        this.superPersonDao = superPersonDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        //ADD SIGHTINGS
        List<Sighting> sightingList = sightingDao.getLast10Sightings();
        model.addAttribute("sightingList", sightingList);
        //ADD SUPERPEOPLE
        List<SuperPerson> superPeople = superPersonDao.getAllSuperPeople();
        model.addAttribute("superPeopleList", superPeople);

        return "index";
    }
}
