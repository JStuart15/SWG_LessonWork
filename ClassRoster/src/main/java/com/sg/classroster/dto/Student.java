/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dto;

import java.util.Objects;

/**
 *
 * @author jstuart15
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String cohort; // java or .net + cohort month/year
    
    //constructor
    public Student(String studentID){
        this.studentId = studentID;
    }
    //getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId(){
        return studentId;
    }
    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.studentId);
        hash = 79 * hash + Objects.hashCode(this.cohort);
        return hash;
    }

    @Override //override the equals function to be specific to our object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.cohort, other.cohort)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString(){
        return "ID: " + studentId + " |Name: " + firstName + " "
                + lastName + " |Cohort: " + cohort;
    }
    
}
