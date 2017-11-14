/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.controller;

import com.sg.messagetemplater.dao.CompanyDao;
import com.sg.messagetemplater.dao.CompanyDaoJsonFileImpl;
import com.sg.messagetemplater.model.Company;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jstuart15
 */
@RestController
@CrossOrigin
public class CompanyController {

    private final CompanyDao companyDao = new CompanyDaoJsonFileImpl();

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }
    
    @RequestMapping(value = "company/{id}", method = RequestMethod.GET)
    public Company getCompany(@PathVariable("id") long id){
        return companyDao.getCompanyById(id);
    }
}
