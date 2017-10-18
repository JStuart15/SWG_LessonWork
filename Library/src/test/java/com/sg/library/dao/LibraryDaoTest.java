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
import static org.junit.Assert.fail;
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContest.xml");
        
        dao = ctx.getBean("libraryDao", LibraryDao.class);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddAuthor() {
        System.out.println("addAuthor");
        Author author = null;
        LibraryDao instance = new LibraryDaoImpl();
        instance.addAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteAuthor() {
        System.out.println("deleteAuthor");
        int authorId = 0;
        LibraryDao instance = new LibraryDaoImpl();
        instance.deleteAuthor(authorId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateAuthor() {
        System.out.println("updateAuthor");
        Author author = null;
        LibraryDao instance = new LibraryDaoImpl();
        instance.updateAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAuthorById() {
        System.out.println("getAuthorById");
        int id = 0;
        LibraryDao instance = new LibraryDaoImpl();
        Author expResult = null;
        Author result = instance.getAuthorById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllAuthors() {
        System.out.println("getAllAuthors");
        LibraryDao instance = new LibraryDaoImpl();
        List<Author> expResult = null;
        List<Author> result = instance.getAllAuthors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddBook() {
        System.out.println("addBook");
        Book book = null;
        LibraryDao instance = new LibraryDaoImpl();
        instance.addBook(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        int bookId = 0;
        LibraryDao instance = new LibraryDaoImpl();
        instance.deleteBook(bookId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateBook() {
        System.out.println("updateBook");
        Book book = null;
        LibraryDao instance = new LibraryDaoImpl();
        instance.updateBook(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBookById() {
        System.out.println("getBookById");
        int id = 0;
        LibraryDao instance = new LibraryDaoImpl();
        Book expResult = null;
        Book result = instance.getBookById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBooksByAuthorId() {
        System.out.println("getBooksByAuthorId");
        int authorId = 0;
        LibraryDao instance = new LibraryDaoImpl();
        List<Book> expResult = null;
        List<Book> result = instance.getBooksByAuthorId(authorId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBooksByPublisherId() {
        System.out.println("getBooksByPublisherId");
        int publisherId = 0;
        LibraryDao instance = new LibraryDaoImpl();
        List<Book> expResult = null;
        List<Book> result = instance.getBooksByPublisherId(publisherId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllBooks() {
        System.out.println("getAllBooks");
        LibraryDao instance = new LibraryDaoImpl();
        List<Book> expResult = null;
        List<Book> result = instance.getAllBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddPublisher() {
        System.out.println("addPublisher");
        Publisher publisher = null;
        LibraryDao instance = new LibraryDaoImpl();
        instance.addPublisher(publisher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeletePublisher() {
        System.out.println("deletePublisher");
        int publisherId = 0;
        LibraryDao instance = new LibraryDaoImpl();
        instance.deletePublisher(publisherId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdatePublisher() {
        System.out.println("updatePublisher");
        Publisher publisher = null;
        LibraryDao instance = new LibraryDaoImpl();
        instance.updatePublisher(publisher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPublisherById() {
        System.out.println("getPublisherById");
        int id = 0;
        LibraryDao instance = new LibraryDaoImpl();
        Publisher expResult = null;
        Publisher result = instance.getPublisherById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllPublishers() {
        System.out.println("getAllPublishers");
        LibraryDao instance = new LibraryDaoImpl();
        List<Publisher> expResult = null;
        List<Publisher> result = instance.getAllPublishers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class LibraryDaoImpl implements LibraryDao {

        public void addAuthor(Author author) {
        }

        public void deleteAuthor(int authorId) {
        }

        public void updateAuthor(Author author) {
        }

        public Author getAuthorById(int id) {
            return null;
        }

        public List<Author> getAllAuthors() {
            return null;
        }

        public void addBook(Book book) {
        }

        public void deleteBook(int bookId) {
        }

        public void updateBook(Book book) {
        }

        public Book getBookById(int id) {
            return null;
        }

        public List<Book> getBooksByAuthorId(int authorId) {
            return null;
        }

        public List<Book> getBooksByPublisherId(int publisherId) {
            return null;
        }

        public List<Book> getAllBooks() {
            return null;
        }

        public void addPublisher(Publisher publisher) {
        }

        public void deletePublisher(int publisherId) {
        }

        public void updatePublisher(Publisher publisher) {
        }

        public Publisher getPublisherById(int id) {
            return null;
        }

        public List<Publisher> getAllPublishers() {
            return null;
        }
    }
    
}
