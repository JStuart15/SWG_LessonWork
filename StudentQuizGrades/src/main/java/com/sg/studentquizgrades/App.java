/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author jstuart15
 */
public class App {

    public static void main(String[] args) {
        int exit = 0;

        Map<String, ArrayList<Integer>> grades = new HashMap<>();
        //ArrayList<Integer> quizzes = new ArrayList<>();
        ConsoleInput io = new ConsoleInput();

        while (exit == 0) {
            int menuselection = displayMenu();
            if (menuselection == 0) {
                System.out.println("Thank you, goodbye");
                break;
            } else {
                if (menuselection == 1) {//View list of students
                    Set<String> keys = grades.keySet();
                    if (keys.size() == 0) {
                        io.print("\nThere are no students to display, please add some.\n");
                    } else {
                        io.print("\nList of Students");
                        for (String k : keys) {
                            io.print("\n" + k);
                        }
                    }
                } else if (menuselection == 2) {//ADD student
                    ArrayList<Integer> quizzes = new ArrayList<>();
                    String name = io.readString("\nEnter the student's name add: ");
                    int score = 0;
                    while (score != -1) {
                        score = io.readInt("Please enter quiz score(s). Enter -1 when done: ", -1, 100);
                        if (score != -1) {
                            quizzes.add(score);
                        }
                    }
                    grades.put(name, quizzes);
                } else if (menuselection == 3) {//REMOVE student
                    String name = io.readString("\nEnter the student's name to remove: ");
                    grades.remove(name);
                } else if (menuselection == 4) {//VIEW quizzes for student
                    String name = io.readString("\nView Quiz Scores > Enter the student's name. ");
                    io.print("\n" + name + "'s scores are: " + grades.get(name));
                } else if (menuselection == 5) {//View average of student's quizzes
                    String name = io.readString("\nView Quiz Average > Enter the student's name. ");
                    int quizSum = 0;
                    ArrayList<Integer> quizAvg = grades.get(name);
                    if (quizAvg.size() == 0) {
                        io.print("There are no quiz scores to display.");
                    } else {
                        for (int i = 0; i < quizAvg.size(); i++) {
                            quizSum += quizAvg.get(i);
                        }
                        io.print("\n" + name + "'s average quiz score is " + quizSum / quizAvg.size());
                    }
                } else if (menuselection == 6) {//average for entire class
                    Set<String> keys = grades.keySet();
                    int sumOfScores = 0;
                    int countOfScores = 0;
                    if (keys.size() == 0) {
                        io.print("\nThere are no students, please add some.\n");
                    } else {
                        io.print("\nAverage quiz score for the entire class: ");
                        for (String k : keys) {
                            ArrayList<Integer> quizAvg = grades.get(k);
                            for (int i = 0; i < quizAvg.size(); i++) {
                                countOfScores += 1;
                                sumOfScores += quizAvg.get(i);
                            }
                        }
                        io.print("" + sumOfScores / countOfScores);
                    }
                } else if (menuselection == 7) {//highest quiz score
                    Map<String, Integer> highestQuiz = new HashMap<>();
                    int maxQuiz = 0;
                    for (String k : grades.keySet()) {
                        ArrayList<Integer> quizzes = grades.get(k);//we have the student's quizzes, we have to find the max
                        for (int i : quizzes) {
                            if (i > maxQuiz) {
                                maxQuiz = i;
                            }//now we have the max quiz for the student so we need to put it into the hash map
                        }
                        highestQuiz.put(k, maxQuiz);//now the student is in the hashmap with their highest score.
                    }//now all students are in the hashmap with their highes scores

                    //go through the hashmap and remove anything that is not the maximum.
                    for (String k : highestQuiz.keySet()) {
                        if (highestQuiz.get(k) < maxQuiz) {
                            highestQuiz.remove(k);
                        }
                    }
                    System.out.println("\nThe maxium quiz scores are: ");
                    for (String k : highestQuiz.keySet()) {
                        System.out.println(k + " with a quiz score of " + highestQuiz.get(k));
                    }

                } else if (menuselection == 8) {//lowest quiz score
                    Map<String, Integer> lowestQuiz = new HashMap<>();
                    int minQuiz = 100;
                    for (String k : grades.keySet()) {
                        ArrayList<Integer> quizzes = grades.get(k);
                        for (int i : quizzes) {
                            if (i < minQuiz) {
                                minQuiz = i;
                            }
                        }
                        lowestQuiz.put(k, minQuiz);
                    }
                    for (String k : lowestQuiz.keySet()) {
                        if (lowestQuiz.get(k) > minQuiz) {
                            lowestQuiz.remove(k);
                        }
                    }
                    System.out.println("\nThe minimum quiz scores are: ");
                    for (String k : lowestQuiz.keySet()) {
                        System.out.println(k + " with a quiz score of " + lowestQuiz.get(k));
                    }
                }
            }
        }
    }

    public static int displayMenu() {
        ConsoleInput input = new ConsoleInput();

        System.out.println("\n\nWhat would you like to do?\n"
                + "\t1 to VIEW a list of students in the system\n"
                + "\t2 to ADD a student to the system\n"
                + "\t3 to REMOVE a student from the system\n"
                + "\t4 to VIEW a list of quiz scores for a given student\n"
                + "\t5 to VIEW the average quiz score for a given student\n"
                + "\t6 to VIEW the average quiz score for the entire class\n"
                + "\t7 to VIEW the student(s) with the highest quiz score\n"
                + "\t8 to VIEW the student(s) with the lowest quiz score\n"
                + "\t0 to EXIT");

        return input.readInt("Please make a selection: ", 0, 8);
    }
}
