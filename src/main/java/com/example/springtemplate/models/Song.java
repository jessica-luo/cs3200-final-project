package com.example.springtemplate.models;

import javax.persistence.*;
import java.sql.Date;

@Entity                                                     // configure class as mapped to a table
@Table(name = "songs")                                        // configure name of source table
public class Song {
    @Id                                                     // configure primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // configure auto_increment
    private Integer id;
    private String title;
    private Float length;
    private Integer streams;
    private Boolean explicit;
    private Integer album_id;

    public Integer getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Integer album_id) {
        this.album_id = album_id;
    }

    public Integer getStreams() {
        return streams;
    }

    public void setStreams(Integer streams) {
        this.streams = streams;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Song(String title, Float length, Integer streams, Boolean explicit, Integer albumId) {

        this.title = title;
        this.length = length;
        this.streams = streams;
        this.explicit = explicit;
        this.album_id = albumId;

    }

    public Song() {
    }
}
