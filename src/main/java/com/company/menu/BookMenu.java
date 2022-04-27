package com.company.menu;

// Create a book controller and also create a book menu
// using the template shown, and we'll demo them

import com.company.controllers.BookController;
import java.util.Scanner;

public class BookMenu {

    public static void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?");
        System.out.println("1. Add a new book ");
        System.out.println("2. Get the book by id");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option){
            case 1:
                System.out.println(BookController.addBook() ? "Successfully added new book " : "Book not added");
                break;
            case 2:
                System.out.println(BookController.getBookById().getName());

            default:
                System.out.println("Invalid option. Try again ");
                menu();
        }
    }
}
