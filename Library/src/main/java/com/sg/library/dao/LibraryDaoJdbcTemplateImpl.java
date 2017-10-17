/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.library.dao;

import com.sg.library.model.Author;
import com.sg.library.model.Book;
import com.sg.library.model.Publisher;
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
public class LibraryDaoJdbcTemplateImpl implements LibraryDao {

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

    private static final String SQL_SELECT_ALL_AUTHORS
            = "select * from authors";

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAuthor(Author author) {
        jdbcTemplate.update(SQL_INSERT_AUTHOR,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getZip(),
                author.getPhone());

        int authorId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        author.setAuthorId(authorId);
    }

    @Override
    public void deleteAuthor(int authorId) {
        jdbcTemplate.update(SQL_DELETE_AUTHOR, authorId);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(SQL_UPDATE_AUTHOR,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getZip(),
                author.getPhone(),
                author.getAuthorId());
    }

    @Override
    public Author getAuthorById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_AUTHOR,
                    new AuthorMapper(),
                    id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SQL_SELECT_ALL_AUTHORS,
                new AuthorMapper());
    }

    @Override
    public void addBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBook(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book getBookById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByAuthorId(int authorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByPublisherId(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getAllBooks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPublisher(Publisher publisher) {
        jdbcTemplate.update(SQL_INSERT_PUBLISHER,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getZip(),
                publisher.getPhone());
        
        int publisherId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        
        publisher.setPublisherId(publisherId);
    }

    @Override
    public void deletePublisher(int publisherId) {
        jdbcTemplate.update(SQL_DELETE_PUBLISHER, publisherId);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(SQL_UPDATE_PUBLISHER,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getZip(),
                publisher.getPhone(),
                publisher.getPublisherId());
    }

    @Override
    public Publisher getPublisherById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PUBLISHER,
                    new PublisherMapper(),
                    id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PUBLISHERS, 
                                  new PublisherMapper());
        
    }

    //mappers
    private static final class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            Author au = new Author();
            au.setFirstName(rs.getString("first_name"));
            au.setLastName(rs.getString("last_name"));
            au.setStreet(rs.getString("street"));
            au.setCity(rs.getString("city"));
            au.setState(rs.getString("state"));
            au.setZip(rs.getString("zip"));
            au.setPhone(rs.getString("phone"));
            au.setAuthorId(rs.getInt("author_id"));
            return au;
        }
    }
    
    private static final class PublisherMapper implements RowMapper<Publisher> {

        @Override
        public Publisher mapRow(ResultSet rs, int i) throws SQLException {
            Publisher pub = new Publisher();
            pub.setPublisherId(rs.getInt("publisher_id"));
            pub.setName(rs.getString("name"));
            pub.setStreet(rs.getString("street"));
            pub.setCity(rs.getString("city"));
            pub.setState(rs.getString("state"));
            pub.setZip(rs.getString("zip"));
            pub.setPhone(rs.getString("phone"));
            return pub;
        }

        
    }
    

}
