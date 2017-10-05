/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistspringmvc.controller;

import com.sg.contactlistspringmvc.dao.ContactListDao;
import com.sg.contactlistspringmvc.model.Contact;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jstuart15
 */
@Controller
public class SearchController {
    private ContactListDao dao;
    
    @Inject
    public SearchController(ContactListDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value="/displaySearchPage", method=RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }
    
    @RequestMapping(value = "/search/contacts", method = RequestMethod.POST)
    @ResponseBody
    public List<Contact> searchContacts(@RequestBody Map<String, String> searchmap){
        
    }
}
