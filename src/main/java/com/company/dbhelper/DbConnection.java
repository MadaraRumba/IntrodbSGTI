package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // Create one static method to return the connection to database via jdbc
    // It is a static method because we do not need multiple connections or instances to database.

    public static Connection getConnection(){

        Connection connection = null;

        try{
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students", "postgres", "Bali2022");
         if (connection != null) System.out.println("Connection Successful");
        } catch(SQLException e) {
        System.out.println("There was a problem connecting to the database.");
        e.printStackTrace();
    }
        return connection;
    }
}
