package org.example.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Document
public class Person {
    @Id
    private String id;

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 2, max = 30, message = "Name contains between 2 and 3 characters")
    private String name;

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 2, max = 30, message = "Lastname contains between 2 and 3 characters")
    private String lastName;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty(message = "Number can not be empty")
    private String phoneNumber;

    @NotEmpty(message = "Password can not be empty")
    @Size(min = 8, message = "Password is too short")
    private String password;

    public Person(){}

    public Person(String id, String name, String lastName, String email, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
