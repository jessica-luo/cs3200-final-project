package com.example.springtemplate.models;

import javax.persistence.*;

@Entity                                                     // configure class as mapped to a table
@Table(name = "artists")                                        // configure name of source table
public class Artist {
    @Id                                                     // configure primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // configure auto_increment
    private Integer id;
    private String name;
    private Integer genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }


    public Artist(String name, Integer genre) {

        this.name = name;
        this.genre = genre;

    }

    public Artist() {
    }
}
