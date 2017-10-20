/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Siting;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface SitingDao {

    public void addSiting(Siting siting);

    public void deleteSiting(int sitingId);

    public void updateSiting(Siting siting);

    public Siting getSitingById(int id);
    
    public List<Siting> getAllSitings();
}
