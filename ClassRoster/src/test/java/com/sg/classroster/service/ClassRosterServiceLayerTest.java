/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dto.Student;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
public class ClassRosterServiceLayerTest {

    ClassRosterServiceLayer service;

    public ClassRosterServiceLayerTest() {
//        ClassRosterDao dao = new ClassRosterDaoStubImpl();
//        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
//        service = new ClassRosterServiceLayerImpl(dao, auditDao);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);

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
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {
        //not testing persistence, rather testing service business rules
        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");
        service.createStudent(student);//if not exceptions then the test passed
    }

    @Test
    public void testCreateStudentDuplicateId() throws Exception {
        Student student = new Student("0001");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");

        try {
            service.createStudent(student);//if we get past this we have failed
            fail("Expected ClassRosterDuplicateIdException was not thrown.");
        } catch (ClassRosterDuplicateIdException e) {
            return; //no need to do anything if we get exception because tests fail on exceptions
        }
    }

    @Test
    public void testCreateStudentInvalidData() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");

        try {
            service.createStudent(student);//if we get past, we failed
            fail("Expected ClassRosterDataValidationException was not thrown.");
        } catch (ClassRosterDataValidationException e) {
            return;
        }
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        assertEquals(1, service.getAllStudents().size());
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
        //test getting something back
        Student student = service.getStudent("0001");
        assertNotNull(student);

        //test getting nothing back, bogus student id
        student = service.getStudent("9999");
        assertNull(student);
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        //test removing valid student
        Student student = service.removeStudent("0001");
        assertNotNull(student);

        //test removing invalid student
        student = service.removeStudent("9999");
        assertNull(student);
    }
}
