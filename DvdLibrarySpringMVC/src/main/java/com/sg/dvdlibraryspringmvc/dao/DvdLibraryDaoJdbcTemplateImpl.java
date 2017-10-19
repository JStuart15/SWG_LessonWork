/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
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
public class DvdLibraryDaoJdbcTemplateImpl implements DvdLibraryDao {

    //PREPARED STATEMENTS
    private static final String SQL_INSERT_DVD
            = "insert into dvds "
            + "(title, release_year, director, rating, notes) "
            + "values (?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_DVD
            = "delete from dvds where dvd_id = ?";

    private static final String SQL_UPDATE_DVD
            = "update dvds set "
            + "title = ?, release_year = ?, director = ?, "
            + "rating = ?, notes = ?"
            + "where dvd_id = ?";

    private static final String SQL_SELECT_ALL_DVDS
            = "select * from dvds";

    private static final String SQL_SELECT_DVD
            = "select * from dvds where dvd_id = ?";

    // JDBC TEMPLATE SETUP
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // DVD METHODS
    // ===========
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getReleaseYear(),
                dvd.getDirector(),
                dvd.getRating(),
                dvd.getNotes());
        
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        
        dvd.setDvdId(newId);
        return dvd;
    }

    @Override
    public void removeDvd(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public void updateDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseYear(),
                dvd.getDirector(),
                dvd.getRating(),
                dvd.getNotes(),
                dvd.getDvdId());
    }

    @Override
    public List<Dvd> getAllDvds() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());
    }

    @Override
    public Dvd getDvdById(int dvdId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD,
                    new DvdMapper(), dvdId);
        } catch (Exception e) {
            return null;
        }
    }

    // MAPPERS
    private static final class DvdMapper implements RowMapper<Dvd>{

        @Override
        public Dvd mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dvd dvd = new Dvd();
            dvd.setDvdId(rs.getInt("dvd_id"));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseYear(rs.getInt("release_year"));
            dvd.setDirector(rs.getString("director"));
            dvd.setRating(rs.getString("rating"));
            dvd.setNotes(rs.getString("notes"));
            return dvd;
        }
    }
}
