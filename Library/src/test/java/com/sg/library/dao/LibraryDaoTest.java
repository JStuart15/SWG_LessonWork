/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.library.dao;

import com.sg.library.model.Author;
import com.sg.library.model.Book;
import com.sg.library.model.Publisher;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jstuart15
 */
public class LibraryDaoTest {
    LibraryDao dao;
    
    public LibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = ctx.getBean("libraryDao", LibraryDao.class);
        
        //delete all books
        List<Book> books = dao.getAllBooks();
        for(Book currentBook : books){
            dao.deleteBook(currentBook.getBookId());
        }
        
        //delete all authors
        List<Author> authors = dao.getAllAuthors();
        for (Author currentAuthor: authors){
            dao.deleteAuthor(currentAuthor.getAuthorId());
        }
        
        //delete all publishers
        List<Publisher> publishers = dao.getAllPublishers();
        for (Publisher currentPublisher : publishers) {
            dao.deletePublisher(currentPublisher.getPublisherId());            
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1212");
        
        dao.addPublisher(publisher);
        
        Publisher fromDao = dao.getPublisherById(publisher.getPublisherId());
        assertEquals(fromDao, publisher);
        
    }
    
}
