/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jstuart15
 */
public class DvdLibraryDaoTest {

    DvdLibraryDao dao;

    public DvdLibraryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "test-applicationContext.xml");

        dao = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class);

        //delete all dvds
        List<Dvd> dvds = dao.getAllDvds();
        for (Dvd currentDvd : dvds) {
            dao.removeDvd(currentDvd.getDvdId());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetDvd() {
        Dvd dvd = new Dvd();
        dvd.setTitle("Forest Gump");
        dvd.setDirector("Zemekis");
        dvd.setNotes("Here are some notes for the movie");
        dvd.setRating("PG-13");
        dvd.setReleaseYear(1992);

        dao.addDvd(dvd);

        Dvd fromDao = dao.getDvdById(dvd.getDvdId());
        assertEquals(fromDao, dvd);
    }

    @Test
    public void testDeleteDvd() {
        Dvd dvd = new Dvd();
        dvd.setTitle("Forest Gump");
        dvd.setDirector("Zemekis");
        dvd.setNotes("Here are some notes for the movie");
        dvd.setRating("PG-13");
        dvd.setReleaseYear(1992);

        dao.addDvd(dvd);

        Dvd fromDao = dao.getDvdById(dvd.getDvdId());
        assertEquals(fromDao, dvd);
        dao.removeDvd(dvd.getDvdId());
        assertNull(dao.getDvdById(dvd.getDvdId()));
        
    }
}
