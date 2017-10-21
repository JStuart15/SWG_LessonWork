/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superpeoplesightings.dao;

import com.sg.superpeoplesightings.model.Organization;
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
public class OrganizationDaoJdbcTemplateImpl implements OrganizationDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PREPARED STATEMENTS
    private static final String SQL_INSERT_ORGANIZATION
            = "insert into organizations (name, description, street, city, "
            + "state, zip, phone) values (?,?,?,?,?,?,?)";

    private static final String SQL_DELETE_ORGANIZATION
            = "delete from organizations where organization_id = ?";

    private static final String SQL_DELETE_SUPER_PEOPLE_ORGANIZATIONS
            = "delete from super_people_organizations where "
            + "organization_id = ?";

    private static final String SQL_SELECT_ORGANIZATION
            = "select * from organizations where organization_id = ?";

    private static final String SQL_SELECT_ALL_ORGANIZATIONS
            = "select * from organizations";

    private static final String SQL_UPDATE_ORGANIZATION
            = "update organizations set name = ?, description = ?, street = ?, "
            + "city = ?, state = ?, zip = ?, phone = ? "
            + "where organization_id = ?";

    //METHODS
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organization org) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                org.getName(), org.getDescription(), org.getStreet(), 
                org.getCity(), org.getState(), org.getZip(), org.getPhone());

        int orgId = jdbcTemplate
                .queryForObject("select LAST_INSERT_ID()", Integer.class);

        org.setOrganizationId(orgId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteOrganization(int orgId) {
        //delete from bridge table
        jdbcTemplate.update(SQL_DELETE_SUPER_PEOPLE_ORGANIZATIONS, orgId);
        //delete from org table
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, orgId);
    }

    @Override
    public void updateOrganization(Organization org) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                org.getName(), org.getDescription(), org.getStreet(), 
                org.getCity(), org.getState(), org.getZip(), org.getPhone(),
                org.getOrganizationId());
    }

    @Override
    public Organization getOrganizationById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION,
                    new OrganizationMapper(),
                    id);
        } catch (DataAccessException e) {
            //return a blank organization
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS,
                new OrganizationMapper());
    }

    protected static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization o = new Organization();
            o.setName(rs.getString("name"));
            o.setDescription(rs.getString("description"));
            o.setStreet(rs.getString("street"));
            o.setCity(rs.getString("city"));
            o.setState(rs.getString("state"));
            o.setZip(rs.getString("zip"));
            o.setPhone(rs.getString("phone"));
            o.setOrganizationId(rs.getInt("organization_id"));
            return o;
        }
    }

}
