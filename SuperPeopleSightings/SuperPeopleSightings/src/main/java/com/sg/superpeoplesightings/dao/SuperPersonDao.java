/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.SuperPerson;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface SuperPersonDao {

    public void addSuperPerson(SuperPerson superPerson);

    public void deleteSuperPerson(int superPersonId);

    public void updateSuperPerson(SuperPerson superPerson);

    public SuperPerson getSuperPersonById(int id);

    public List<SuperPerson> getAllSuperPeople();
}
