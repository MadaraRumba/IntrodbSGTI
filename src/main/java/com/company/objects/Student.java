package com.company.objects;

public class Student {

    // define the properties of the Student Object
    private int id;
    private String name;
    private int age;

    // define constructor
    public Student(){

    }

    // define a constructor
    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // define getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
