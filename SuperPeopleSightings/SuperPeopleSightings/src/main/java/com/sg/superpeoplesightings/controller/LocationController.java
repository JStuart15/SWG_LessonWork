/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.LocationDao;
import com.sg.superpeoplesightings.model.Location;
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
public class LocationController {

    LocationDao locationDao;

    @Inject
    public LocationController(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @RequestMapping(value = "/displayLocationsPage", method = RequestMethod.GET)
    public String displayLocationsPage(Model model) {
        List<Location> locationList = locationDao.getAllLocations();
        model.addAttribute("locationList", locationList);
        return "locations";
    }

    @RequestMapping(value = "/displayLocationDetails", method = RequestMethod.GET)
    public String displayLocationDetails(HttpServletRequest request, Model model) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);
        Location location = locationDao.getLocationById(locationId);
        model.addAttribute("location", location);
        return "locationDetails";
    }

    @RequestMapping(value = "/createLocation", method = RequestMethod.POST)
    public String createLocation(HttpServletRequest request) {

        //do validations using HTML
        Location location = new Location();
        location.setName(request.getParameter("name"));
        location.setDescription(request.getParameter("description"));
        location.setStreet(request.getParameter("street"));
        location.setCity(request.getParameter("city"));
        location.setState(request.getParameter("state"));
        location.setZip(request.getParameter("zip"));
        location.setIsActive(Boolean.TRUE);

        try {
            location.setLatitude(Double.parseDouble(request.getParameter("latitude")));
            location.setLongitude(Double.parseDouble(request.getParameter("longitude")));
        } catch (Exception e) {
            //don't set anything if the values are left blank
        }

        locationDao.addLocation(location);

        //redirect to the displayLocations page to reload it
        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);
        locationDao.deleteLocation(locationId);
        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/editLocation", method = RequestMethod.POST)
    public String editLocation(@Valid @ModelAttribute("location") Location location,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editLocationForm";
        }
        location.setIsActive(Boolean.TRUE);
        locationDao.updateLocation(location);
        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/displayEditLocationForm", method = RequestMethod.GET)
    public String displayEditLocationForm(HttpServletRequest request, Model model) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);
        Location location = locationDao.getLocationById(locationId);
        model.addAttribute("location", location);
        return "editLocationForm";
    }
}
