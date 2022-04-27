package com.company.controllers;

import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class StudentController {

    // initialise the scanner

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    // Add student controller
    public static boolean addStudent() {
        // prompting the user for data
        System.out.print("Enter the name of the student: ");
        String name = scanner.next();

        System.out.print("Enter the age of the student: ");
        int age = scanner.nextInt();

        try {
            // INSERT INTO students (name, age) VALUES ('name', age);
            ps = getConnection().prepareStatement("INSERT INTO students(name,age) VALUES(' " + name + "', " + age + ")");

            ps.execute(); // execute the sql command
            return true; // return if successful

        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    // Get student by id controller

    public static Student getStudentById() {

        // promt the user to enter the id of the student they want to retrieve

        System.out.print("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {

            ps = getConnection().prepareStatement("SELECT * FROM students WHERE id =" + id);
            rs = ps.executeQuery();

            // define variables to temporarily hold each field in the result set

            int studentId, age;
            String name;

            // instantiate the student object to return at the end of the method execution

            Student student = new Student();

            // loop throught the result set and add the necessary values to the student object
            while (rs.next()) {
                studentId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setName(name);
                student.setId(studentId);
                student.setAge(age);
            }

            return student;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void editStudent() {

        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        System.out.println("What field would you like to edit? (name, age) : ");
        String fieldToEdit = scanner.next();

        System.out.println("What value do you want to edit it to? : ");
        String update = scanner.next();

        try {
            ps = getConnection().prepareStatement("UPDATE students SET " + fieldToEdit + "= ' " + update + "WHERE id = " + id);
            ps.execute();
            System.out.println("Successfully updated student data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent() {
        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM students WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//Attempt to add 3 student's scores into the score table
//Create a method called addStudentScores() and use that to perform the task
//Use the id of an existing student

    public static boolean addStudentScores() {
        System.out.println("Enter the ID of the student: ");
        int id = scanner.nextInt();

        System.out.println("Enter the Math score of the student: ");
        int math = scanner.nextInt();

        System.out.println("Enter the English score of the student: ");
        int english = scanner.nextInt();

        System.out.println("Enter the Physics score of the student: ");
        int physics = scanner.nextInt();

        System.out.println("Enter the Chemistry score of the student: ");
        int chemistry = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO scores (studentid, math, english, physics, " +
                    "chemistry) VALUES(" + id + ", " + math + ", " + english + ", " + physics + ", " + chemistry + ") ");
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Database Error");
            return false;
        }
    }

//    Attempt to create a deleteScore method in your students controller
//    to deleta a particular student's score by the id


//    Attempt to create a deleteScore method in your student controller
//    to delete a particular student's score by the id.
//    it should delete the entire row.

    public static void deleteScore() {
        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM scores WHERE id=" + id);
            System.out.println("Scores deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
