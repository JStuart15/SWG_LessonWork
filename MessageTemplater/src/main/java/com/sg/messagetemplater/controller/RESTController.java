/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.controller;


import com.sg.messagetemplater.dao.CompanyDao;
import com.sg.messagetemplater.dao.CompanyDaoJsonFileImpl;
import com.sg.messagetemplater.dao.GuestDao;
import com.sg.messagetemplater.dao.GuestDaoJsonFileImpl;
import com.sg.messagetemplater.dao.MessageTemplateDao;
import com.sg.messagetemplater.dao.MessageTemplateDaoJsonFileImpl;
import com.sg.messagetemplater.model.Company;
import com.sg.messagetemplater.model.Guest;
import com.sg.messagetemplater.model.MessageTemplate;
import java.util.List;
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

    private final GuestDao guestDao = new GuestDaoJsonFileImpl();
    private final MessageTemplateDao messageTemplateDao = new MessageTemplateDaoJsonFileImpl();
    private final CompanyDao companyDao = new CompanyDaoJsonFileImpl();

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
