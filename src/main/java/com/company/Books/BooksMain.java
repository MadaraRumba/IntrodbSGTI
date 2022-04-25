package com.company.Books;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

//Create the same class in your code and add the following fields:
// id(int),
// name(String),
// price(float).
// In your main method, create a List of books and return books that are more expensive than $5.

public class BooksMain {
    public static void main(String[] args) {
        List<Books>books = new ArrayList<>();
        books.add(new Books(1, "The Lion, the Witch and the Wardrobe", 11));
        books.add(new Books(2, "She: A History of Adventure", 3));
        books.add(new Books(3, "The Da Vinci Code", 10));
        books.add(new Books(4, "The Catcher in the Rye", 8));
        books.add(new Books(5, "Black Beauty", 1));

//        List<Books> expensiveBooks = filterBooks(books, 5.0f);
//        System.out.println(expensiveBooks.size() + " books are more expensive than 5.0 EUR");

        System.out.println(filterBooks(books));
    }

    private static List<String> filterBooks(List<Books> books){
        // an anonymous function - lambda
//        books.removeIf(book -> book.getPrice()<5);
//            return books;

        // Define a list of string for the bookNames
        List<String> bookNames = new ArrayList<>();

        // Use a loop to filter the books less than 5
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getPrice()<5) books.remove(books.get(i));
            }

        // add each remaining book name to the bookNames list
        books.forEach(book -> bookNames.add(book.getName()));
        return bookNames;
        }
    }

//    private static List<Books> filterBooks(List<Books> books, float filterFrom) {
//        List<Books> filtered = new ArrayList<>();
//        for (Books book : books) {
//            if (book.getPrice() > filterFrom) {
//                filtered.add(book);
//            }
//        }
//        return filtered;
//
//    }
//}
