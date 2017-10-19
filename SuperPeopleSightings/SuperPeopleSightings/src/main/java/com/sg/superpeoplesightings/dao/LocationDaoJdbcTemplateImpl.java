/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jstuart15
 */
public class LocationDaoJdbcTemplateImpl implements LocationDao {

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

    //METHODS
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location l) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                l.getName(),
                l.getDescription(),
                l.getStreet(),
                l.getCity(),
                l.getState(),
                l.getZip(),
                l.getPhone(),
                l.getLatitude(),
                l.getLongitude());

        int locationId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        l.setLocationId(locationId);
    }

    @Override
    public void deleteLocation(int locationId) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationId);
    }

    @Override
    public void updateLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getLocationById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION, 
                    new LocationMapper(),
                    id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS,
                new LocationMapper());
    }

    //MAPPER
    private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location l = new Location();
            l.setName(rs.getString("name"));
            l.setDescription(rs.getString("description"));
            l.setStreet(rs.getString("street"));
            l.setCity(rs.getString("city"));
            l.setState(rs.getString("state"));
            l.setZip(rs.getString("zip"));
            l.setPhone(rs.getString("phone"));
            l.setLatitude(rs.getDouble("latitude"));
            l.setLongitude(rs.getDouble("longitude"));
            l.setLocationId(rs.getInt("location_id"));
            return l;
        }

    }

}
