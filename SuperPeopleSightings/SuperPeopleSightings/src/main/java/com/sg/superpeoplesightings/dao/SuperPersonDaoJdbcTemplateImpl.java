/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.SuperPerson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jstuart15
 */
public class SuperPersonDaoJdbcTemplateImpl implements SuperPersonDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //PREPARED STATEMENTS
    private static final String SQL_DELETE_SUPER_PERSON
            = "delete from super_people where super_person_id = ?";

    private static final String SQL_DELETE_SUPER_PEOPLE_ORGANIZATIONS
            = "delete from super_people_organizations where super_person_id = ?";

    private static final String SQL_DELETE_SUPER_PEOPLE_SITINGS
            = "delete from super_people_sightings where super_person_id = ?";

    private static final String SQL_GET_ALL_SUPER_PEOPLE
            = "select * from super_people";

    private static final String SQL_INSERT_SUPER_PERSON
            = "insert into super_people (super_power_id, name, description) "
            + "values (?, ?, ?)";

    //METHODS
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuperPerson(SuperPerson siting) {
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSuperPerson(int superPersonId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_SITINGS, superPersonId);
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_ORGANIZATIONS, superPersonId);
        jdbcTemplate.update(SQL_DELETE_SUPER_PERSON, superPersonId);
    }

    @Override
    public void updateSuperPerson(SuperPerson siting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPerson getSuperPeopleById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPerson> getAllSuperPeople() {
        return jdbcTemplate.query(SQL_GET_ALL_SUPER_PEOPLE,
                new SuperPersonMapper());
    }

    //MAPPER
    private static final class SuperPersonMapper implements RowMapper<SuperPerson> {

        @Override
        public SuperPerson mapRow(ResultSet rs, int i) throws SQLException {
            SuperPerson sp = new SuperPerson();
            sp.setSuperPersonId(rs.getInt("super_person_id"));
            sp.setSuperPowerId(rs.getInt("super_power_id"));
            sp.setName(rs.getString("name"));
            sp.setDescription(rs.getString("description"));
            return sp;
        }
    }

}
