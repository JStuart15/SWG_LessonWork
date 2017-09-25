/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 * Stub to be used for testing.
 *
 * @author jstuart15
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao {

    Student onlyStudent;
    List<Student> studentList = new ArrayList<>();

    public ClassRosterDaoStubImpl() {
        //add dummy student data so that when it is instantiated it will have a student
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Joe");
        onlyStudent.setLastName("Smith");
        onlyStudent.setCohort("Java-May-2017");

        studentList.add(onlyStudent);
    }

    @Override
    public Student addStudent(String studentID, Student student) throws ClassRosterPersistenceException {
        if (studentID.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return studentList;
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

}
