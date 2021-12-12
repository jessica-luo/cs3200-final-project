package com.example.springtemplate.daos;

import com.example.springtemplate.models.Playlist;
import com.example.springtemplate.repositories.PlaylistRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PlaylistRestOrmDao {
    @Autowired
    PlaylistRestRepository playlistRepository;

    @PostMapping("/api/playlists")                          // map this method to an HTTP POST
    public Playlist createPlaylist(@RequestBody Playlist playlist) {      // parse new user from HTTP Request BODY
        return playlistRepository.save(playlist);                 // insert new user into users table
    }

    @GetMapping("/api/playlists")                   // map this method to an HTTP GET request
    public List<Playlist> findAllPlaylists() {            // execute this method if URL matches /api/users
        return playlistRepository.findAllPlaylists();     // retrieve all records from users table and return as list of users
    }

    @GetMapping("/api/playlists/{playlistId}")              // map this method to HTTP GET request
    public Playlist findPlaylistById(                         //  execute this method when URL matches /api/users/ID
                                                              @PathVariable("playlistId") Integer id) {         // parse user ID from path variable userID
        return playlistRepository.findPlaylistById(id);       // retrieve single user by ID and return as instance of User
    }

    @PutMapping("/api/playlists/{playlistId}")                          // map method to HTTP PUT
    public Playlist updatePlaylist(
            @PathVariable("playlistId") Integer id,                    // parse user's ID from URL
            @RequestBody Playlist playlistUpdates) {                       // parse user object from BODY
        Playlist playlist = playlistRepository.findPlaylistById(id);               // retrieve user from database
        playlist.setName(playlistUpdates.getName());             // update
        playlist.setLikes(playlistUpdates.getLikes());               // user fields
        playlist.setPub(playlistUpdates.getPub());               // with new
        playlist.setUserId(playlistUpdates.getUserId());               // values from
        return playlistRepository.save(playlist);                          // save changes to database
    }

    @DeleteMapping("/api/playlists/{playlistId}")       // map this method to HTTP DELETE request
    public void deletePlaylist(                        // execute this method if URL matches /api/users/ID
                                                       @PathVariable("playlistId") Integer id) {  // parse user's ID from path variable
        playlistRepository.deleteById(id);              // use repository to permanently remove the user by their ID
    }
}