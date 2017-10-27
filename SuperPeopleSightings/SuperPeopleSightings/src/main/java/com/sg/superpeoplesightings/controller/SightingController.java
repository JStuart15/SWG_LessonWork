/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.LocationDao;
import com.sg.superpeoplesightings.dao.OrganizationDao;
import com.sg.superpeoplesightings.dao.SightingDao;
import com.sg.superpeoplesightings.dao.SuperPersonDao;
import com.sg.superpeoplesightings.dao.SuperPowerDao;
import com.sg.superpeoplesightings.model.Location;
import com.sg.superpeoplesightings.model.Sighting;
import com.sg.superpeoplesightings.model.SuperPerson;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class SightingController {

    SuperPersonDao superPersonDao;
    SuperPowerDao superPowerDao;
    OrganizationDao orgDao;
    SightingDao sightingDao;
    LocationDao locationDao;

    @Inject
    public SightingController(SuperPersonDao superPersonDao, SuperPowerDao superPowerDao,
            OrganizationDao orgDao, SightingDao sightingDao, LocationDao locationDao) {
        this.superPersonDao = superPersonDao;
        this.superPowerDao = superPowerDao;
        this.orgDao = orgDao;
        this.sightingDao = sightingDao;
        this.locationDao = locationDao;
    }

    @RequestMapping(value = "/displaySightingsPage", method = RequestMethod.GET)
    public String displaySightingsPage(Model model) {
        List<SuperPerson> superPersonList = superPersonDao.getAllSuperPeople();
        List<Sighting> sightingList = sightingDao.getAllSightings();//@todo - sort by name
        List<Location> locationList = locationDao.getAllLocations();
        model.addAttribute("superPersonList", superPersonList);
        model.addAttribute("sightingList", sightingList);
        model.addAttribute("locationList", locationList);
        return "sightings";
    }

    @RequestMapping(value = "/createSighting", method = RequestMethod.POST)
    public String createSighting(HttpServletRequest request) {
        //SuperPerson superPerson = new SuperPerson();
        Sighting sighting = new Sighting();
        List<SuperPerson> superPeople = new ArrayList<>();
        String[] superPeopleIds = request.getParameterValues("spSelect");
        Location location = new Location();

        //set the date of the sighting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        sighting.setDate(LocalDate.parse(request.getParameter("date"), formatter));
        //set the location of the sighting
        location = locationDao.getLocationById(
                Integer.parseInt(request.getParameter("location")));
        sighting.setLocation(location);
        //get and set super humans sighting from the multi-select
        for (String superPeopleId : superPeopleIds) {
            superPeople.add(superPersonDao
                    .getSuperPersonById(Integer.parseInt(superPeopleId)));
        }
        sighting.setSuperPeople(superPeople);

        sightingDao.addSighting(sighting);
        return "redirect:displaySightingsPage";
    }
    
    @RequestMapping(value = "/displaySightingDetails", method = RequestMethod.GET)
    public String displaySightingDetails(HttpServletRequest request, Model model) {
        String sightingIdParameter = request.getParameter("sightingId");
        int sightingId = Integer.parseInt(sightingIdParameter);
        Sighting sighting = sightingDao.getSightingById(sightingId);
        model.addAttribute("sighting", sighting);
        return "sightingDetails";
    }

    @RequestMapping(value = "/deleteSighting", method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        String sightingIdParameter = request.getParameter("sightingId");
        int sightingId = Integer.parseInt(sightingIdParameter);
        sightingDao.deleteSighting(sightingId);
        return "redirect:displaySightingsPage";
    }
//
////    @RequestMapping(value = "/editSuperPerson", method = RequestMethod.POST)
////    public String editSuperPerson(@Valid @ModelAttribute("superPerson") SuperPerson superPerson,
////            BindingResult result) {
////        //@todo - add validations to the superPerson object.
////        if (result.hasErrors()) {
////            return "editSuperPersonForm";
////        }
////
////        superPersonDao.updateSuperPerson(superPerson);
////        return "redirect:displaySuperPersonsPage";
////    }
//

    @RequestMapping(value = "/displayEditSightingForm", method = RequestMethod.GET)
    public String displayEditSightingForm(HttpServletRequest request, Model model) {
        List<SuperPerson> superPersonList = superPersonDao.getAllSuperPeople();//@todo - high - sort the list by name
        List<Location> locationList = locationDao.getAllLocations();
        
        String sightingIdParameter = request.getParameter("sightingId");
        int sightingId = Integer.parseInt(sightingIdParameter);
        Sighting sighting = sightingDao.getSightingById(sightingId);
        model.addAttribute("sighting", sighting);
        model.addAttribute("locationList", locationList);
        model.addAttribute("superPersonList", superPersonList);
        return "editSightingForm";
    }
}
