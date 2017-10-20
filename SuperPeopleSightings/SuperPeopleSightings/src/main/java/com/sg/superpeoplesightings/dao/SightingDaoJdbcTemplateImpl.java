/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jstuart15
 */
public class SightingDaoJdbcTemplateImpl implements SightingDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_DELETE_SIGHTING
            = "delete from sightings where sighting_id = ?";
    
    private static final String SQL_DELETE_SUPER_PEOPLE_SIGHTINGS
            = "delete from super_people_sightings where sighting_id = ?";
    
    private static final String SQL_SELECT_ALL_SIGHTINGS
            = "select * from sightings";

    @Override
    public void addSighting(Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_SIGHTINGS, sightingId);
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    public void updateSighting(Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sighting getSightingById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sighting> getAllSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS, new SightingMapper());
    }
    
    //MAPPER
    private static final class SightingMapper implements RowMapper<Sighting> {
        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting s = new Sighting();
            s.setSightingId(rs.getInt("sighting_id"));
            s.setLocationId(rs.getInt("location_id"));
            //s.setDate(rs.getDate("date"));  @todo
            return s;
        }
    }
    

}
