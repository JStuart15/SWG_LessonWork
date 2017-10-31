/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Sighting;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface SightingDao {

    public Sighting addSighting(Sighting siting);

    public void deleteSighting(int sitingId);

    public void updateSighting(Sighting siting);

    public Sighting getSightingById(int id);

    public List<Sighting> getAllSightings();

    public List<Sighting> getLast10Sightings();

}
