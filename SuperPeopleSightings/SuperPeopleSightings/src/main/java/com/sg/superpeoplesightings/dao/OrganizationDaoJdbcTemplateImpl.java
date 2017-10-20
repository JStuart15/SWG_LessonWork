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
            = "insert into organizations (name) "
            + "values (?)";

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
            = "update organizations set name = ?, description = ?"
            + "where organization_id = ?";

    //METHODS
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organization org) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                org.getName());

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
    public void updateOrganization(Organization orgId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization getOrganizationById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION,
                    new OrganizationMapper(),
                    id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS,
                new OrganizationMapper());
    }

    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization o = new Organization();
            o.setName(rs.getString("name"));
            o.setOrganizationId(rs.getInt("organization_id"));
            return o;
        }
    }

}
