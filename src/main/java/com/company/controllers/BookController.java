package com.company.controllers;

import com.company.Books.Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class BookController {

    // initialise the scanner
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    // Add book controller
    public static boolean addBook(){
        // prompting the user for data
        System.out.print("Enter the name of the book: ");
        String name = scanner.next();

        System.out.print("Enter the price of the book: ");
        int price = scanner.nextInt();

        try{
            ps = getConnection().prepareStatement("INSERT INTO books(name,price) VALUES(' " + name + "', " + price + ")" );

            ps.execute(); // execute the sql command
            return true; // return if successful

        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    // Get student by id controller

    public static Books getBookById(){

        // prompt the user to enter the id of the student they want to retrieve

        System.out.print("Enter the id of the book: ");
        int id = scanner.nextInt();

        try{

            ps = getConnection().prepareStatement("SELECT * FROM books WHERE id =" + id);
            rs = ps.executeQuery();

            // define variables to temporarily hold each field in the result set

            int bookId, price;
            String name;

            // instantiate the student object to return at the end of the method execution

            Books book = new Books();

            // loop through the result set and add the necessary values to the student object
            while(rs.next()){
                bookId = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                book.setName(name);
                book.setId(bookId);
                book.setPrice(price);
            }

            return book;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

}
