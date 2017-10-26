/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.SightingDao;
import com.sg.superpeoplesightings.model.Sighting;
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

    @Inject
    public HomeController(SightingDao sightingDao) {
        this.sightingDao = sightingDao;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHomePage(Model model){
        List<Sighting> sightingList = sightingDao.getAllSightings();
        model.addAttribute("sightingList", sightingList);
        return "index";
    }
}
