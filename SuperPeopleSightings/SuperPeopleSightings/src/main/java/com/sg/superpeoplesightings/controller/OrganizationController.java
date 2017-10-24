/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.OrganizationDao;
import com.sg.superpeoplesightings.model.Organization;
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
public class OrganizationController {
    
    OrganizationDao orgDao;
    
    @Inject
    public OrganizationController(OrganizationDao orgDao){
        this.orgDao = orgDao;
    }
    
    @RequestMapping(value = "/displayOrganizationsPage", method = RequestMethod.GET)
    public String displayOrganizationsPage(Model model) {
        List<Organization> organizationList = orgDao.getAllOrganizations();
        model.addAttribute("organizationList", organizationList);
        return "organizations";
    }
}
