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
public class OrganizationController {

    OrganizationDao organizationDao;

    @Inject
    public OrganizationController(OrganizationDao orgDao) {
        this.organizationDao = orgDao;
    }

    @RequestMapping(value = "/displayOrganizationsPage", method = RequestMethod.GET)
    public String displayOrganizationsPage(Model model) {
        List<Organization> organizationList = organizationDao.getAllOrganizations();
        model.addAttribute("organizationList", organizationList);
        return "organizations";
    }

    @RequestMapping(value = "/displayOrganizationDetails", method = RequestMethod.GET)
    public String displayOrganizationDetails(HttpServletRequest request, Model model, BindingResult result) {
        String organizationIdParameter = request.getParameter("organizationId");
        int organizationId = Integer.parseInt(organizationIdParameter);
        Organization organization = organizationDao.getOrganizationById(organizationId);
        model.addAttribute("organization", organization);
        return "organizationDetails";
    }

    @RequestMapping(value = "/displayEditOrganizationForm", method = RequestMethod.GET)
    public String displayEditOrganizationForm(HttpServletRequest request, Model model) {
        String organizationIdParameter = request.getParameter("organizationId");
        int organizationId = Integer.parseInt(organizationIdParameter);
        Organization organization = organizationDao.getOrganizationById(organizationId);
        model.addAttribute("organization", organization);
        return "editOrganizationForm";
    }

    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public String createOrganization(HttpServletRequest request) {
        Organization organization = new Organization();
        organization.setName(request.getParameter("name"));
        organization.setDescription(request.getParameter("description"));
        organization.setStreet(request.getParameter("street"));
        organization.setCity(request.getParameter("city"));
        organization.setState(request.getParameter("state"));
        organization.setZip(request.getParameter("zip"));
        organization.setPhone(request.getParameter("phone"));

        organizationDao.addOrganization(organization);

        //redirect to the displayOrganizations page to reload it
        return "redirect:displayOrganizationsPage";
    }
    
    @RequestMapping(value = "/createOrganizationErrors", method = RequestMethod.POST)
    public String createOrganizationErrors(@Valid @ModelAttribute("organization") Organization organization, BindingResult result) {
        if(result.hasErrors()){
            return "displayOrganizationsPage";
        }
        organizationDao.addOrganization(organization);

        //redirect to the displayOrganizations page to reload it
        return "redirect:displayOrganizationsPage";
    }

    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {
        String organizationIdParameter = request.getParameter("organizationId");
        int organizationId = Integer.parseInt(organizationIdParameter);
        organizationDao.deleteOrganization(organizationId);
        return "redirect:displayOrganizationsPage";
    }

    @RequestMapping(value = "/editOrganization", method = RequestMethod.POST)
    public String editOrganization(@Valid @ModelAttribute("organization") Organization organization,
            BindingResult result) {
        //@todo - add validations to the organization object.
        if (result.hasErrors()) {
            return "editOrganizationForm";
        }

        organizationDao.updateOrganization(organization);
        return "redirect:displayOrganizationsPage";
    }
}
