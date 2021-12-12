package com.example.springtemplate.models;

import java.sql.Date;
import javax.persistence.*;                                 // JPA's ORM package

@Entity                                                     // configure class as mapped to a table
@Table(name = "users")                                        // configure name of source table
public class User {
    @Id                                                     // configure primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // configure auto_increment
    private Integer id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private Date date_of_birth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return date_of_birth;
    }

    public void setDateOfBirth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public User(String firstname, String lastname, String username, String password, String email, Date date_of_birth) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.date_of_birth = date_of_birth;

    }

    public User() {
    }
}
