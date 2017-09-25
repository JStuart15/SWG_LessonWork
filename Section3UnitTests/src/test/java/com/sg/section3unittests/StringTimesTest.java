/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section3unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jstuart15
 */
public class StringTimesTest {

    public StringTimesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of stringTimes method, of class StringTimes.
     */
    // stringTimes("Hi", 2) -> "HiHi"
    // stringTimes("Hi", 3) -> "HiHiHi"
    // stringTimes("Hi", 1) -> "Hi"
    @Test
    public void testStringTimes_2() {
        StringTimes myST = new StringTimes();
        String stringToTest = myST.stringTimes("Hi", 2);
        assertEquals("HiHi", stringToTest);
    }

    @Test
    public void testStringTimes_3() {
        StringTimes myST = new StringTimes();
        String stringToTest = myST.stringTimes("Hi", 3);
        assertEquals("HiHiHi", stringToTest);
        //assertEquals(0, stringToTest.compareTo("HiHiHi"));
        
    }

    @Test
    public void testStringTimes_1() {
        StringTimes myST = new StringTimes();
        String stringToTest = myST.stringTimes("Hi", 1);
        assertEquals("Hi", stringToTest);
    }

}
