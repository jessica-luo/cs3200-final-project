package com.example.springtemplate.models;

import javax.persistence.*;
import java.sql.Date;

@Entity                                                     // configure class as mapped to a table
@Table(name = "albums")                                        // configure name of source table
public class Album {
    @Id                                                     // configure primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // configure auto_increment
    private Integer id;
    private String title;
    private Date release_date;
    private Integer artist_id;

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

    public Date getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(Date releaseDate) {
        this.release_date = releaseDate;
    }

    public Integer getArtistId() {
        return artist_id;
    }

    public void setArtistId(Integer artistId) {
        this.artist_id = artistId;
    }


    public Album(String title, Date releasedate, Integer artistid) {

        this.title = title;
        this.release_date = releasedate;
        this.artist_id = artistid;

    }

    public Album() {
    }
}
