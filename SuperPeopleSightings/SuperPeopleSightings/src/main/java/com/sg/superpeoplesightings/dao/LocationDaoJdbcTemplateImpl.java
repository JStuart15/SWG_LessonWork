/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jstuart15
 */
public class LocationDaoJdbcTemplateImpl implements LocationDao{
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //PREPARED STATEMENTS
    private static final String SQL_INSERT_LOCATION
            = "insert into locations (locations_id, name, description, street, city, state, zip, phone, latitude, longitude) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_LOCATION
            = "delete from locations where location_id = ?";
    
    private static final String SQL_UPDATE_LOCATION
            = "update locations "
            + "set name = ?, "
            + "description = ?, "
            + "street = ?, "
            + "city = ?, "
            + "state = ?, "
            + "zip = ?, "
            + "phone = ?, "
            + "latitude = ?, "
            + "longitude + ? "
            + "where locations_id = ?";
    
    private static final String SQL_SELECT_LOCATION
            = "select * from locations where location_id = ?";
    
    private static final String SQL_SELECT_ALL_LOCATIONS
            = "select * from locations";
    
    @Override
    public void addLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLocation(int locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getLocationById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> getAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
