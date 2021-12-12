package com.example.springtemplate.daos;

import com.example.springtemplate.models.PlaylistAdd;
import com.example.springtemplate.repositories.PlaylistAddRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PlaylistAddRestOrmDao {
    @Autowired
    PlaylistAddRestRepository playlistaddRepository;

    @PostMapping("/api/playlistadds")                          // map this method to an HTTP POST
    public PlaylistAdd createPlaylistAdd(@RequestBody PlaylistAdd playlistadd) {      // parse new playlistadd from HTTP Request BODY
        return playlistaddRepository.save(playlistadd);                 // insert new playlistadd into playlistadd table
    }

    @GetMapping("/api/playlistadds")                   // map this method to an HTTP GET request
    public List<PlaylistAdd> findAllPlaylistAdds() {            // execute this method if URL matches /api/playlistadds
        return playlistaddRepository.findAllPlaylistAdds();     // retrieve all records from playlistadds table and return as list of playlistadds
    }

    @GetMapping("/api/playlistadds/{playlistaddId}")              // map this method to HTTP GET request
    public PlaylistAdd findPlaylistAddById(                         //  execute this method when URL matches /api/playlistadds/ID
                                                                    @PathVariable("playlistaddId") Integer id) {         // parse playlistadd ID from path variable playlistaddID
        return playlistaddRepository.findPlaylistAddById(id);       // retrieve single playlistadd by ID and return as instance of PlaylistAdd
    }

    @PutMapping("/api/playlistadds/{playlistaddId}")                          // map method to HTTP PUT
    public PlaylistAdd updatePlaylistAdd(
            @PathVariable("playlistaddId") Integer id,                    // parse playlistadd's ID from URL
            @RequestBody PlaylistAdd playlistaddUpdates) {                       // parse playlistadd object from BODY
        PlaylistAdd playlistadd = playlistaddRepository.findPlaylistAddById(id);               // retrieve playlistadd from database
        playlistadd.setRationale(playlistaddUpdates.getRationale());             // update
        playlistadd.setSong_id(playlistaddUpdates.getSong_id());               // playlistadd fields
        playlistadd.setPlaylist_id(playlistaddUpdates.getPlaylist_id());               // with new
        return playlistaddRepository.save(playlistadd);                          // save changes to database
    }

    @DeleteMapping("/api/playlistadds/{playlistaddId}")       // map this method to HTTP DELETE request
    public void deletePlaylistAdd(                        // execute this method if URL matches /api/playlistadd/ID
                                                          @PathVariable("playlistaddId") Integer id) {  // parse playlistadd's ID from path variable
        playlistaddRepository.deleteById(id);              // use repository to permanently remove the playlistadd by their ID
    }
}