package com.example.springtemplate.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity                                                     // configure class as mapped to a table
@Table(name = "playlists")                                        // configure name of source table
public class Playlist {
    @Id                                                     // configure primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // configure auto_increment
    private Integer id;
    private String name;
    private Integer likes;
    private Boolean pub;
    private Integer user_id;

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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getPub() {
        return pub;
    }

    public void setPub(Boolean pub) {
        this.pub = pub;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public Playlist(String name, Integer likes, Boolean pub, Integer user_id) {

        this.name = name;
        this.likes = likes;
        this.pub = pub;
        this.user_id = user_id;

    }

    public Playlist() {
    }
}
