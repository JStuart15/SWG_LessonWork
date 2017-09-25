/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jstuart15
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMETER = "::";

    private Map<String, Student> students = new HashMap<>();

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.  Overwrites any file that is there.
     *
     * @throws ClassRosterPersistenceException if an error occurs writing to the file
     */
    private void writeRoster() throws ClassRosterPersistenceException {
        // We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("-_- Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            //write the Student object to the file
            out.println(currentStudent.getStudentId() + DELIMETER
                    + currentStudent.getFirstName() + DELIMETER
                    + currentStudent.getLastName() + DELIMETER
                    + currentStudent.getCohort());
            //force PrintWriter to write currentStudent to the file
            out.flush();
        }
        //Clean up
        out.close();
    }

    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException("-_- Could not load roster data into memory.", e);
        }

        //currentLine holds the most recent line read from the file
        String currentLine;

        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMETER
        String[] currentTokens;

        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object.  Process while we have more lines in the file.
        while (scanner.hasNextLine()) {
            //get the next line in the file
            currentLine = scanner.nextLine();
            //break up the line into tokens
            currentTokens = currentLine.split(DELIMETER);
            //create a new Student object and put it into the map of students
            Student currentStudent = new Student(currentTokens[0]);
            //Set the remaining values on currentStudent manually
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);

            //put currentStudent into the map using studentID as the key
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        //close scanner
        scanner.close();
    }

    @Override
    public Student addStudent(String studentID, Student student)
            throws ClassRosterPersistenceException {
        loadRoster();
        Student newStudent = students.put(studentID, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList<Student>(students.values());//was a hash map, this converts to ArrayList;
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

}
