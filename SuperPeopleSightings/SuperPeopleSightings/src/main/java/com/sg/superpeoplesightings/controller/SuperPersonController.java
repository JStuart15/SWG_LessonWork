/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.controller;

import com.sg.superpeoplesightings.dao.AlbumDao;
import com.sg.superpeoplesightings.dao.OrganizationDao;
import com.sg.superpeoplesightings.dao.SuperPersonDao;
import com.sg.superpeoplesightings.dao.SuperPowerDao;
import com.sg.superpeoplesightings.model.Organization;
import com.sg.superpeoplesightings.model.Picture;
import com.sg.superpeoplesightings.model.SuperPerson;
import com.sg.superpeoplesightings.model.SuperPower;
import java.io.File;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jstuart15
 */
@Controller
public class SuperPersonController {

    public static final String pictureFolder = "images/";

    SuperPersonDao superPersonDao;
    SuperPowerDao superPowerDao;
    OrganizationDao orgDao;
    AlbumDao albumDao;

    @Inject
    public SuperPersonController(SuperPersonDao superPersonDao, SuperPowerDao superPowerDao,
            OrganizationDao orgDao, AlbumDao albumDao) {
        this.superPersonDao = superPersonDao;
        this.superPowerDao = superPowerDao;
        this.orgDao = orgDao;
        this.albumDao = albumDao;
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
    public String createSuperPerson(HttpServletRequest request,
            Model model,
            @RequestParam("picture") MultipartFile pictureFile) {
        SuperPerson superPerson = new SuperPerson();
        SuperPower superPower = new SuperPower();
        List<Organization> orgs = new ArrayList<>();
        
        //PICTURE RELATED ACTIONS
        // only save the pictureFile if the user actually uploaded something
        if (!pictureFile.isEmpty()) {
            try {
                // we want to put the uploaded image into the 
                // <pictureFolder> folder of our application. getRealPath
                // returns the full path to the directory under Tomcat
                // where we can save files.
                String savePath = request
                        .getSession()
                        .getServletContext()
                        .getRealPath("/") + pictureFolder;
                File dir = new File(savePath);
                // if <pictureFolder> directory is not there, 
                // go ahead and create it
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // get the filename of the uploaded file - we'll use the
                // same name on the server.
                String filename = pictureFile.getOriginalFilename();
                // transfer the contents of the uploaded pictureFile to 
                // the server
                pictureFile.transferTo(new File(savePath + filename));

                // we successfully saved the pictureFile, now save a 
                // Picture to the DAO
                Picture picture = new Picture();
                picture.setFilename(pictureFolder + filename);
                superPerson.setImageFileName(pictureFolder + filename);
                albumDao.addPicture(picture);

                // redirect to home page to redisplay the entire album
                //return "redirect:home";
            } catch (Exception e) {
                // if we encounter an exception, add the error message 
                // to the model and return back to the pictureFile upload 
                // form page
                model.addAttribute("errorMsg", "File upload failed: "
                        + e.getMessage());
                //return "addPictureForm";
            }
        } else {
            // if the user didn't upload anything, add the error 
            // message to the model and return back to the pictureFile 
            // upload form page
            model.addAttribute("errorMsg",
                    "Please specify a non-empty file.");
            //return "addPictureForm";
        }

        //NON-PICTURE ACTIONS
        String[] orgIds = request.getParameterValues("orgSelect");

        superPerson.setName(request.getParameter("name"));
        superPerson.setDescription(request.getParameter("description"));
        //get and set superpower from select

        try {
            superPower = superPowerDao
                    .getSuperPowerById(Integer.parseInt(request.getParameter("power")));
            superPerson.setSuperPower(superPower);
        } catch (Exception e) {
            //we don't require superpowers
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

    @RequestMapping(value = "/deleteSuperPerson", method = RequestMethod.GET)
    public String deleteSuperPerson(HttpServletRequest request) {
        String superPersonIdParameter = request.getParameter("superPersonId");
        int superPersonId = Integer.parseInt(superPersonIdParameter);
        superPersonDao.deleteSuperPerson(superPersonId);
        return "redirect:displaySuperPeoplePage";
    }

    @RequestMapping(value = "/editSuperPerson", method = RequestMethod.POST)
    public String editSuperPerson(@Valid @ModelAttribute("superPerson") SuperPerson superPerson,
            BindingResult result, HttpServletRequest request) {

        //@todo - add validations to the superPerson object.
        if (result.hasErrors()) {
            return "editSuperPersonForm";
        }

        //SET THE SUPERPOWER
        try {
            int superPowerId = Integer.parseInt(request.getParameter("power"));
            superPerson.setSuperPower(superPowerDao.getSuperPowerById(superPowerId));
        } catch (Exception e) {
            //no action, we allow no powers
        }

        //SET THE ORGANIZATIONS
        List<Organization> orgs = new ArrayList<>();
        try {
            String[] orgIds = request.getParameterValues("orgList");
            for (String orgId : orgIds) {
                orgs.add(orgDao.getOrganizationById(Integer.parseInt(orgId)));
            }
            superPerson.setOrgs(orgs);
        } catch (Exception e) {
            //no action - we allow a superperson with no orgs
        }

        superPersonDao.updateSuperPerson(superPerson);
        return "redirect:displaySuperPeoplePage";
    }

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
