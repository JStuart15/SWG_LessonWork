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
public interface SuperPeopleDao {

    public void addSuperPeople(SuperPerson siting);

    public void deleteSuperPeople(int sitingId);

    public void updateSuperPeople(SuperPerson siting);

    public SuperPerson getSuperPeopleById(int id);

    public List<SuperPerson> getAllSuperPeoples();
}
