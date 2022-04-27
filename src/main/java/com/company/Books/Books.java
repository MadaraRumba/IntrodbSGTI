package com.company.Books;

//Create the same class in your code and add the following fields:
// id(int),
// name(String),
// price(float).
// In your main method, create a List of books and return books that are more expensive than $5.

public class Books {

    // define properties
    private int id;
    private String name;
    private int price;

    // an empty constructor? whyyyy tho
    public Books(){

    }

    // define constructor
    public Books(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // define getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) { this.price = price; }
}
