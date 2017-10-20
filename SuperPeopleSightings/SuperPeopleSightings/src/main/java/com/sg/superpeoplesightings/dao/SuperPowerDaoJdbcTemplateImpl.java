/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.SuperPower;
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
public class SuperPowerDaoJdbcTemplateImpl implements SuperPowerDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_INSERT_SUPER_POWER
            = "insert into super_powers (description) values (?)";

    private static final String SQL_SELECT_ALL_SUPER_POWERS
           = "select * from super_powers";
    
    private static final String SQL_DELETE_SUPER_POWER
            = "delete from super_powers where super_power_id = ?";
    
    private static final String SQL_SELECT_SUPER_POWER_BY_SUPER_POWER_ID
            = "select * from super_powers where super_power_id = ?";
    
    private static final String SQL_UPDATE_SUPER_POWER
            = "update super_powers set description = ? where super_power_id = ?";
    
    // METHODS
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuperPower(SuperPower superPower) {
        jdbcTemplate.update(SQL_INSERT_SUPER_POWER,
                superPower.getDescription());
        
        int superPowerId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        
        superPower.setSuperPowerId(superPowerId);
    }

    @Override
    public void deleteSuperPower(int superPowerId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_POWER, superPowerId);
    }

    @Override
    public void updateSuperPower(SuperPower superPower) {
        jdbcTemplate.update(SQL_UPDATE_SUPER_POWER,
                superPower.getDescription(),
                superPower.getSuperPowerId());
    }

    @Override
    public SuperPower getSuperPowerById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPER_POWER_BY_SUPER_POWER_ID,
                    new SuperPowerMapper(), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<SuperPower> getAllSuperPowers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPER_POWERS,
                new SuperPowerMapper());
    }

    //MAPPER
    private static final class SuperPowerMapper implements RowMapper<SuperPower>{

        @Override
        public SuperPower mapRow(ResultSet rs, int i) throws SQLException {
            SuperPower sp = new SuperPower();
            sp.setSuperPowerId(rs.getInt("super_power_id"));
            sp.setDescription(rs.getString("description"));
            return sp;
        }
    }
    
}
