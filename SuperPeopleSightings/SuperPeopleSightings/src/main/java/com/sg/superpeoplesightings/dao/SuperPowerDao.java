/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.SuperPower;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface SuperPowerDao {
    
    public void addSuperPower(SuperPower superPower);
    
    public void deleteSuperPower(int superPowerId);
    
    public void updateSuperPower(SuperPower superPower);
    
    public SuperPower getSuperPowerById(int id);
    
    public List<SuperPower> getAllSuperPowers();
}
