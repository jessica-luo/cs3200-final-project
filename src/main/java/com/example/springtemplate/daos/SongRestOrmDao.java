package com.example.springtemplate.daos;

import com.example.springtemplate.models.Song;
import com.example.springtemplate.repositories.SongRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SongRestOrmDao {
    @Autowired
    SongRestRepository songRepository;

    @PostMapping("/api/songs")                          // map this method to an HTTP POST
    public Song createSong(@RequestBody Song song) {      // parse new user from HTTP Request BODY
        return songRepository.save(song);                 // insert new user into users table
    }

    @GetMapping("/api/songs")                   // map this method to an HTTP GET request
    public List<Song> findAllSongs() {            // execute this method if URL matches /api/users
        return songRepository.findAllSongs();     // retrieve all records from users table and return as list of users
    }

    @GetMapping("/api/songs/{songId}")              // map this method to HTTP GET request
    public Song findSongById(                         //  execute this method when URL matches /api/users/ID
                                                      @PathVariable("songId") Integer id) {         // parse user ID from path variable userID
        return songRepository.findSongById(id);       // retrieve single user by ID and return as instance of User
    }

    @PutMapping("/api/songs/{songId}")                          // map method to HTTP PUT
    public Song updateSong(
            @PathVariable("songId") Integer id,                    // parse user's ID from URL
            @RequestBody Song songUpdates) {                       // parse user object from BODY
        Song song = songRepository.findSongById(id);               // retrieve user from database
        song.setTitle(songUpdates.getTitle());             // update
        song.setLength(songUpdates.getLength());               // user fields
        song.setStreams(songUpdates.getStreams());               // with new
        song.setExplicit(songUpdates.getExplicit());
        song.setAlbum_id(songUpdates.getAlbum_id());  // values from
        return songRepository.save(song);                          // save changes to database
    }

    @DeleteMapping("/api/songs/{songId}")       // map this method to HTTP DELETE request
    public void deleteSong(                        // execute this method if URL matches /api/users/ID
                                                   @PathVariable("songId") Integer id) {  // parse user's ID from path variable
        songRepository.deleteById(id);              // use repository to permanently remove the user by their ID
    }
}