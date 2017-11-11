/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplate.controller;

import com.sg.messagetemplate.dao.CompanyDao;
import com.sg.messagetemplate.dao.GuestDao;
import com.sg.messagetemplate.dao.MessageTemplateDao;
import com.sg.messagetemplate.model.Company;
import com.sg.messagetemplate.model.Guest;
import com.sg.messagetemplate.model.MessageTemplate;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jstuart15
 */
@CrossOrigin
@RestController
public class RESTController {

    private GuestDao guestDao;
    private MessageTemplateDao messageTemplateDao;
    private CompanyDao companyDao;

    @Inject
    public RESTController(GuestDao guestDao,
            MessageTemplateDao messageTemplateDao, CompanyDao companyDao) {
        this.guestDao = guestDao;
        this.messageTemplateDao = messageTemplateDao;
        this.companyDao = companyDao;
    }

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    @ResponseBody
    public List<Guest> getAllGuests() {
        return guestDao.getAllGuests();
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    @ResponseBody
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }
    
    @RequestMapping(value = "/messagetemplates", method=RequestMethod.GET)
    @ResponseBody
    public List<MessageTemplate> getAllMessageTemplates(){
        return messageTemplateDao.getAllMessageTemplates();
    }
}
