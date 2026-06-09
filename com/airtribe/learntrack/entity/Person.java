package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.InputValidators;
import com.airtribe.learntrack.util.IdGenerator;

public class Person {
    private final String id;
    private String firstName;
    private String lastName;
    private String email;

    // parameterized constructor
    public Person(String firstName, String lastName, String email) {
        InputValidators.isValidFirstName(firstName);
        InputValidators.isValidLastName(lastName);
        InputValidators.isValidEmail(email);
        
        this.id = IdGenerator.getNextPersonId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

     // parameterized constructor -- overloading -- without email
    public Person(String firstName, String lastName) {
        InputValidators.isValidFirstName(firstName);
        InputValidators.isValidLastName(lastName);
        
        this.id = IdGenerator.getNextPersonId();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        InputValidators.isValidFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        InputValidators.isValidLastName(lastName);
        this.lastName = lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        InputValidators.isValidEmail(email);
        this.email = email;
    }
}