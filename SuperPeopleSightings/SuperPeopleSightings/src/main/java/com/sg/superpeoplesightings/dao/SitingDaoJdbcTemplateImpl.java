/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Siting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jstuart15
 */
public class SitingDaoJdbcTemplateImpl implements SitingDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_DELETE_SITING
            = "delete from sitings where siting_id = ?";
    
    private static final String SQL_DELETE_SUPER_PEOPLE_SITINGS
            = "delete from super_people_sitings where siting_id = ?";
    
    private static final String SQL_SELECT_ALL_SITINGS
            = "select * from sitings";

    @Override
    public void addSiting(Siting siting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSiting(int sitingId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_SITINGS, sitingId);
        jdbcTemplate.update(SQL_DELETE_SITING, sitingId);
    }

    @Override
    public void updateSiting(Siting siting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Siting getSitingById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Siting> getAllSitings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SITINGS, new SitingMapper());
    }
    
    //MAPPER
    private static final class SitingMapper implements RowMapper<Siting> {
        @Override
        public Siting mapRow(ResultSet rs, int i) throws SQLException {
            Siting s = new Siting();
            s.setSitingId(rs.getInt("siting_id"));
            s.setLocationId(rs.getInt("location_id"));
            //s.setDate(rs.getDate("date"));  @todo
            return s;
        }
    }
    

}
