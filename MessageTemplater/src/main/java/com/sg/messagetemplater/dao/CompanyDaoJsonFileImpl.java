/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.messagetemplater.model.Company;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class CompanyDaoJsonFileImpl implements CompanyDao {

    private List<Company> companyList = new ArrayList<>();

    @Override
    public List<Company> getAllCompanies() {
        loadCompanies();
        return companyList;
    }

    @Override
    public Company getCompanyById(long id) {
        loadCompanies();
        for (Company company : companyList) {
            if (company.getId() == id) {
                return company;
            } 
        }
        return null;
    }

    private void loadCompanies() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File fileName = new File("Companies.json");
            companyList = mapper.readValue(fileName,
                    new TypeReference<List<Company>>() {
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
