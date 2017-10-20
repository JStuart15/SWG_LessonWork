/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Organization;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface OrganizationDao {
    
    public void addOrganization(Organization org);
    
    public void deleteOrganization (Organization orgId);
    
    public void updateOrganization (Organization orgId);
    
    public Organization getOrganizationById (int id);
    
    public List<Organization> getAllOrganizations();
    
}
