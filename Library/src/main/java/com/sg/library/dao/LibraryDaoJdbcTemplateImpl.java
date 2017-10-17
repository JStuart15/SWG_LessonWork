/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.library.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jstuart15
 */
public class LibraryDaoJdbcTemplateImpl {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Prepared statements for AUTHOR
    private static final String SQL_INSERT_AUTHOR
            = "insert into authors (first_name, last_name, street, city, "
            + "state, zip, phone) values (?,?,?,?,?,?,?)";

    private static final String SQL_DELETE_AUTHOR
            = "delete from authors where author_id = ?";

    private static final String SQL_UPDATE_AUTHOR
            = "update authors set first_name = ?, last_name = ?, street = ?, "
            + "city = ?, state = ?, zip = ?, phone = ? where author_id = ?";

    private static final String SQL_SELECT_AUTHOR
            = "select * from authors where author_id = ?";

    private static final String SQL_SELECT_AUTHORS_BY_BOOK_ID
            = "select au.* from authors au "
            + "inner join books_authors ba on au.author_id = ba.author_id "
            + "where ba.book_id = ?";

    //Prepared Statements for BOOKS and BOOKS_AUTHORS
    private static final String SQL_INSERT_BOOK
            = "insert into books "
            + "(isbn, title, publisher_id, price, publish_date) "
            + "values (?,?,?,?,?)";

    private static final String SQL_INSERT_BOOKS_AUTHORS
            = "insert into books_authors (book_id, author_id) values (?,?)";

    private static final String SQL_DELETE_BOOK
            = "delete from books where book_id = ?";
    
    private static final String SQL_DELETE_BOOKS_AUTHORS
            = "delete from books_authors where book_id = ?";
    
    private static final String SQL_SELECT_BOOK
            = "select * from books where book_id = ?";
    
    private static final String SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID
            = "select author_id from books_authors where book_id = ?";
    
    private static final String SQL_SELECT_ALL_BOOKS
            = "select * from books";
    
    private static final String SQL_SELECT_BOOKS_BY_AUTHOR_ID
            = "select b.*"
            + "from books b"
            + "join books_authors ba on author_id"
            + "where b.book_id = ba.book_id and ba.author_id = ?;";
    
    //Prepared statements for PUBLISHER
    private static final String SQL_SELECT_BOOKS_BY_PUBLISHER_ID
            = "select * from books where publisher_id = ?";
    
    private static final String SQL_INSERT_PUBLISHER
            = "insert into publishers (name, street, city, state, zip, phone) "
            + "values (?,?,?,?,?,?)";
    
    private static final String SQL_DELETE_PUBLISHER
            = "delete from publishers where publisher_id = ?";
    
    private static final String SQL_UPDATE_PUBLISHER
            = "update publishers set name = ?, street = ?, city = ?, "
            + "state = ?, zip = ?, phone = ? where publisher_id  = ?";
    
    private static final String SQL_SELECT_PUBLISHER
            = "select * from publishers where publisher_id = ?";
    
    private static final String SQL_SELECT_PUBLISHER_BY_BOOK_ID
            = "select pub.* "
            + "from publishers pub "
            + "inner join books on pub.publisher_id = books.publisher_id "
            + "where books.book_id = ?";
    
    private static final String SQL_SELECT_ALL_PUBLISHERS
            = "select * from publishers";
}
