/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.SuperPeople;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface SuperPeopleDao {

    public void addSuperPeople(SuperPeople siting);

    public void deleteSuperPeople(int sitingId);

    public void updateSuperPeople(SuperPeople siting);

    public SuperPeople getSuperPeopleById(int id);

    public List<SuperPeople> getAllSuperPeoples();
}
