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

    public List<SuperPerson> getAllSuperPeopleForALocation(Location location);

    public List<Location> getAllLocationsForASuperPerson(SuperPerson sp);

    public List<Sighting> getAllSightingsForADate(LocalDate now);

    public List<SuperPerson> getAllSuperPeopleForAnOrg(Organization org);

    public List<Organization> getAllOrgsForASuperPerson(SuperPerson sp);
}
