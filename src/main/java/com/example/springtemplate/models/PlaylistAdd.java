package com.example.springtemplate.models;

import javax.persistence.*;
import java.sql.Date;

@Entity                                                     // configure class as mapped to a table
@Table(name = "playlistadds")                                        // configure name of source table
public class PlaylistAdd {
    @Id                                                     // configure primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // configure auto_increment
    private Integer id;
    private String rationale;
    private Integer song_id;
    private Integer playlist_id;

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    public Integer getSong_id() {
        return song_id;
    }

    public void setSong_id(Integer song_id) {
        this.song_id = song_id;
    }

    public Integer getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(Integer playlist_id) {
        this.playlist_id = playlist_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public PlaylistAdd(String rational, Integer song_id, Integer playlist_id) {

        this.rationale = rational;
        this.song_id = playlist_id;
        this.playlist_id = playlist_id;

    }

    public PlaylistAdd() {
    }
}
