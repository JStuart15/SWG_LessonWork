/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.dao.OrganizationDaoJdbcTemplateImpl.OrganizationMapper;
import com.sg.superpeoplesightings.dao.SuperPowerDaoJdbcTemplateImpl.SuperPowerMapper;
import com.sg.superpeoplesightings.model.Organization;
import com.sg.superpeoplesightings.model.SuperPerson;
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

    private static final String SQL_INSERT_SUPER_PEOPLE_ORGANIZATIONS
            = "insert into super_people_organizations "
            + "(super_person_id, organization_id) values (?, ?)";

    private static final String SQL_SELECT_SUPER_POWER_BY_SUPER_PERSON_ID
            = "select sp.* from super_powers sp "
            + "inner join super_people speople on speople.super_power_id = "
            + "sp.super_power_id where speople.super_person_id = ?";

    private static final String SQL_SELECT_SUPER_PERSON
            = "select * from super_people where super_person_id = ?";

    private static final String SQL_SELECT_ORGS_BY_SUPER_PERSON_ID
            = "select orgs.* from organizations orgs "
            + "inner join super_people_organizations spo on "
            + "spo.organization_id = orgs.organization_id "
            + "where spo.super_person_id = ?";
    
    private static final String SQL_UPDATE_SUPER_PERSON
            = "update super_people set super_power_id = ?, name = ?, "
            + "description = ? where super_person_id = ?";

    //METHODS
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    //@todo - a service validation should make sure that we have a superPower
    // before calling the addSuperPerson method.
    public void addSuperPerson(SuperPerson superPerson) {
        jdbcTemplate.update(SQL_INSERT_SUPER_PERSON,
                superPerson.getSuperPower().getSuperPowerId(),
                superPerson.getName(),
                superPerson.getDescription());

        superPerson.setSuperPersonId(jdbcTemplate.queryForObject(
                "select LAST_INSERT_ID()", Integer.class));

        //now update the super_people_organizations table
        insertSuperPeopleOrganizations(superPerson);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSuperPerson(int superPersonId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_SITINGS, superPersonId);
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_ORGANIZATIONS, superPersonId);
        jdbcTemplate.update(SQL_DELETE_SUPER_PERSON, superPersonId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSuperPerson(SuperPerson superPerson) {
        //update super_person table
        jdbcTemplate.update(SQL_UPDATE_SUPER_PERSON,
                superPerson.getSuperPower().getSuperPowerId(),
                superPerson.getName(),
                superPerson.getDescription(),
                superPerson.getSuperPersonId());
        
        //delete org relationships and reset them
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_ORGANIZATIONS, 
                superPerson.getSuperPersonId());
        
        //now update the super_people_organizations table
        insertSuperPeopleOrganizations(superPerson);
    }

    @Override
    public SuperPerson getSuperPersonById(int id) {
        try {
            //get info from super_people table
            SuperPerson sp = jdbcTemplate.queryForObject(SQL_SELECT_SUPER_PERSON,
                    new SuperPersonMapper(),
                    id);
            //get organizations for the super person
            sp.setOrgs(findOrgsForSuperPerson(sp));
            //get super power for the super person
            sp.setSuperPower(findSuperPowerForSuperPerson(sp));
            return sp;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<SuperPerson> getAllSuperPeople() {
        return jdbcTemplate.query(SQL_GET_ALL_SUPER_PEOPLE,
                new SuperPersonMapper());
    }

    //HELPERS
    private void insertSuperPeopleOrganizations(SuperPerson superPerson) {
        final int superPersonId = superPerson.getSuperPersonId();
        final List<Organization> orgs = superPerson.getOrgs();
        try {
            for (Organization org : orgs) {
                jdbcTemplate.update(SQL_INSERT_SUPER_PEOPLE_ORGANIZATIONS,
                        superPersonId, org.getOrganizationId());
            }
        } catch (DataAccessException | NullPointerException e) {
            //no action since we want to allow a super person add without
            //organizations
        }
    }

    private SuperPower findSuperPowerForSuperPerson(SuperPerson sp) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SUPER_POWER_BY_SUPER_PERSON_ID,
                new SuperPowerMapper(),
                sp.getSuperPersonId());
    }

    private List<Organization> findOrgsForSuperPerson(SuperPerson sp) {
        return jdbcTemplate.query(SQL_SELECT_ORGS_BY_SUPER_PERSON_ID,
                new OrganizationMapper(),
                sp.getSuperPersonId());
    }

    //MAPPER
    protected static final class SuperPersonMapper implements RowMapper<SuperPerson> {

        @Override
        public SuperPerson mapRow(ResultSet rs, int i) throws SQLException {
            SuperPerson sp = new SuperPerson();
            sp.setSuperPersonId(rs.getInt("super_person_id"));
            //sp.setSuperPowerId(rs.getInt("super_power_id"));
            sp.setName(rs.getString("name"));
            sp.setDescription(rs.getString("description"));
            return sp;
        }
    }
}
