/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.warmup;

import java.util.ArrayList;
import java.util.List;
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
public class BowlingScoreTest {

    public BowlingScoreTest() {
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
     * Test of calculateScore method, of class BowlingScore.
     */
    @Test
    public void testCalculatePerfectScore() {
        BowlingScore scoreToTest = new BowlingScore();
        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 10, 10});  //300

        assertEquals(300, scoreToTest.calculateScore(frames));
    }

    @Test
    public void testThreeFrames() {
        BowlingScore scoreToTest = new BowlingScore();
        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{9, 1}); //36
        assertEquals(36, scoreToTest.calculateScore(frames));
    }

    @Test
    public void testFullGameAllEights() {
        BowlingScore scoreToTest = new BowlingScore();
        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0}); //80
        assertEquals(80, scoreToTest.calculateScore(frames));

    }

    @Test
    public void testFiveFrames() {
        BowlingScore scoreToTest = new BowlingScore();

        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2}); //82
        assertEquals(82, scoreToTest.calculateScore(frames));
    }

    @Test
    public void testFullGameVariousScores() {
        BowlingScore scoreToTest = new BowlingScore();

        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{8, 1});
        frames.add(new Integer[]{9, 0});
        frames.add(new Integer[]{7, 3});
        frames.add(new Integer[]{6, 3});
        frames.add(new Integer[]{8, 2, 5}); //173
        assertEquals(173, scoreToTest.calculateScore(frames));

    }

}
