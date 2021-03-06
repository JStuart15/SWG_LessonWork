/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface LocationDao {

    public Location addLocation(Location location);

    public void deleteLocation(int locationId);

    public void updateLocation(Location location);

    public Location getLocationById(int id);

    public List<Location> getAllLocations();
}
