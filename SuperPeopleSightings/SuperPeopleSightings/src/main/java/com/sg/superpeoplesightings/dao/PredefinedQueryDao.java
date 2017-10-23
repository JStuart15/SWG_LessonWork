/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
import com.sg.superpeoplesightings.model.Organization;
import com.sg.superpeoplesightings.model.Sighting;
import com.sg.superpeoplesightings.model.SuperPerson;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface PredefinedQueryDao {

    public List<SuperPerson> getAllSuperPeopleForALocation(int locationId);

    public List<Location> getAllLocationsForASuperPerson(int spId);

    public List<Sighting> getAllSightingsForADate(LocalDate now);

    public List<SuperPerson> getAllSuperPeopleForAnOrg(int orgId);

    public List<Organization> getAllOrgsForASuperPerson(int spId);
}
