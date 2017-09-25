/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.service.ClassRosterDataValidationException;

import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterDuplicateIdException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.ui.ClassRosterView;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class ClassRosterController {

    //private ClassRosterView view = new ClassRosterView();
    //private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    private ClassRosterView view;
    private ClassRosterServiceLayer service;

    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (ClassRosterPersistenceException 
                | ClassRosterDuplicateIdException 
                | ClassRosterDataValidationException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemovedStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
        view.displayRemovedStudentSuccessBanner();
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        view.displayStudent(service.getStudent(view.getStudentIdChoice()));
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterPersistenceException,
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);

    }
}
