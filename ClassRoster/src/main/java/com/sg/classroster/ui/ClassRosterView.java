/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class ClassRosterView {

    //UserIO io = new UserIOConsoleImpl();
    private UserIO io;

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");
        return io.readInt("Please select from the above choices.",
                1, 5);
    }

    public void displayErrorMessage(String errorMsg){
        io.print("=== Error ===");
        io.print(errorMsg);
    }
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter Student ID");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student");
        }
        io.readString("Please hit enter to continue.");
    }

    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter first name");
        String lastName = io.readString("Please enter last name");
        String cohort = io.readString("Please enter cohort");

        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);

        return currentStudent;
    }

    public void displayRemovedStudentBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemovedStudentSuccessBanner() {
        io.readString("Student successfully removed. Please hit enter to continue.");
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Student succesfully created. Please hit enter to continue");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            io.print(currentStudent.getStudentId() + ": "
                    + currentStudent.getFirstName() + " "
                    + currentStudent.getLastName());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
}
