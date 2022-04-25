package com.company;

import com.company.dbhelper.DbConnection;
import com.company.menu.BookMenu;
import com.company.menu.StudentMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        StudentMenu.menu();

        BookMenu.menu();
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            scanner.nextInt();
//        } catch (Exception e){
//            System.out.println("The value entered is not a string");
//        }

        DbConnection.getConnection();

    }
}
