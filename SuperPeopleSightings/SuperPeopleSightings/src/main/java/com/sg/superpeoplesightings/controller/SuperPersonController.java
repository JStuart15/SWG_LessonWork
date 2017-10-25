/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.OrganizationDao;
import com.sg.superpeoplesightings.dao.SuperPersonDao;
import com.sg.superpeoplesightings.dao.SuperPowerDao;
import com.sg.superpeoplesightings.model.Organization;
import com.sg.superpeoplesightings.model.SuperPerson;
import com.sg.superpeoplesightings.model.SuperPower;
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
public class SuperPersonController {

    SuperPersonDao superPersonDao;
    SuperPowerDao superPowerDao;
    OrganizationDao orgDao;

    @Inject
    public SuperPersonController(SuperPersonDao superPersonDao, SuperPowerDao superPowerDao,
            OrganizationDao orgDao) {
        this.superPersonDao = superPersonDao;
        this.superPowerDao = superPowerDao;
        this.orgDao = orgDao;
    }

    @RequestMapping(value = "/displaySuperPeoplePage", method = RequestMethod.GET)
    public String displaySuperPersonsPage(Model model) {
        List<SuperPerson> superPersonList = superPersonDao.getAllSuperPeople();
        List<SuperPower> superPowerList = superPowerDao.getAllSuperPowers();//@todo - high - sort the list by name
        List<Organization> orgList = orgDao.getAllOrganizations(); //@todo - high - sort by orgName
        model.addAttribute("superPersonList", superPersonList);
        model.addAttribute("superPowerList", superPowerList);
        model.addAttribute("orgList", orgList);
        return "superpeople";
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
        List<Organization> orgs = new ArrayList<>();
        String[] orgIds = request.getParameterValues("orgSelect");
        
        superPerson.setName(request.getParameter("name"));
        superPerson.setDescription(request.getParameter("description"));
        //get and set superpower from select
        try {
            superPower = superPowerDao
                    .getSuperPowerById(Integer.parseInt(request.getParameter("power")));
            superPerson.setSuperPower(superPower);
        } catch (Exception e) {
            //we don't require a superpower to be entered
        }
        
        //get and set organizations from multi-select
        try {
            for (String orgId : orgIds) {
                orgs.add(orgDao.getOrganizationById(Integer.parseInt(orgId)));
            }
            superPerson.setOrgs(orgs);
        } catch (Exception e) {
            //we don't require orgs to be set
        }
        
        superPersonDao.addSuperPerson(superPerson);
        return "redirect:displaySuperPeoplePage";
    }
//

    @RequestMapping(value = "/deleteSuperPerson", method = RequestMethod.GET)
    public String deleteSuperPerson(HttpServletRequest request) {
        String superPersonIdParameter = request.getParameter("superPersonId");
        int superPersonId = Integer.parseInt(superPersonIdParameter);
        superPersonDao.deleteSuperPerson(superPersonId);
        return "redirect:displaySuperPeoplePage";
    }
//
//    @RequestMapping(value = "/editSuperPerson", method = RequestMethod.POST)
//    public String editSuperPerson(@Valid @ModelAttribute("superPerson") SuperPerson superPerson,
//            BindingResult result) {
//        //@todo - add validations to the superPerson object.
//        if (result.hasErrors()) {
//            return "editSuperPersonForm";
//        }
//
//        superPersonDao.updateSuperPerson(superPerson);
//        return "redirect:displaySuperPersonsPage";
//    }
//

    @RequestMapping(value = "/displayEditSuperPersonForm", method = RequestMethod.GET)
    public String displayEditSuperPersonForm(HttpServletRequest request, Model model) {
        List<SuperPower> superPowerList = superPowerDao.getAllSuperPowers();//@todo - high - sort the list by name
        List<Organization> orgList = orgDao.getAllOrganizations(); //@todo - high - sort by orgName
        String superPersonIdParameter = request.getParameter("superPersonId");
        int superPersonId = Integer.parseInt(superPersonIdParameter);
        SuperPerson superPerson = superPersonDao.getSuperPersonById(superPersonId);
        model.addAttribute("superPerson", superPerson);
        model.addAttribute("superPowerList", superPowerList);
        model.addAttribute("orgList", orgList);
        return "editSuperPersonForm";
    }
}
