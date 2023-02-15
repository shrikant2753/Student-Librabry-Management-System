package com.example.Student_Library_Management_System.DTOs;

//This is an just object that will be used to take request from postman

public class AuthorEntryDto {

    //It will contain the parameters that we want to send from postman
    //id is not contain here, because we don't want to accept it from postman
    //and id is autoincrement
    private String name;
    private int age;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
