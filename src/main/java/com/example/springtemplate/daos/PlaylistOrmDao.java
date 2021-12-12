package com.example.springtemplate.daos;

import com.example.springtemplate.models.Playlist;
import com.example.springtemplate.repositories.PlaylistRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaylistOrmDao {
    @Autowired
    // create an instance of the user
    PlaylistRestRepository playlistRepository;                                          // repository and use it to implement
    // all these CRUD methods

    @GetMapping("/orm/playlists/create/{fn}/{ln}/{un}/{pw}/{em}/{db}")
    // return the user inserted into the
    public Playlist createPlaylist(@PathVariable("nm") String name,                    // database use parameters to create
                                   @PathVariable("lk") Integer likes,                     // new user instance
                                   @PathVariable("pb") Boolean pub,
                                   @PathVariable("us") Integer user_id) {
        Playlist playlist = new Playlist(name, likes, pub, user_id);       // using the constructor
        // insert into database and
        return playlistRepository.save(playlist);                                      // return resulting record

        // when using @GetMapping and @Path Variable,
        // access the resource through HTTP, pass parameters in path, parse path, variables, and pass as parameters
        // create instance, insert into database, and return new record
    }


    @GetMapping("/orm/playlists/find")
    public List<Playlist> findAllPlaylists() {
        return playlistRepository.findAllPlaylists();
    }

    @GetMapping("/orm/playlists/find/id/{playlistId}")
    public Playlist findPlaylistById(
            @PathVariable("playlistId") Integer id) {
        return playlistRepository.findPlaylistById(id);
    }

    @GetMapping("/orm/playlists/delete/{playlistId}")
    public void deletePlaylist(@PathVariable("playlistId") Integer id) {                    // accept user's ID to be deleted
        playlistRepository.deleteById(id);                                              // use builtin deleteById method to
        // when @GetMapping and @PathVariable are used                              // remove record
        // encode user's ID at the end of the path
        // parse the user's ID from the path and pass as parameter
    }

    @GetMapping("/orm/playlists/update/{playlistId}/{password}")
    public Playlist updatePlaylist(@PathVariable("playlistId") Integer id, @PathVariable("name") String newName) {
        Playlist playlist = playlistRepository.findPlaylistById(id);
        playlist.setName(newName);
        return playlistRepository.save(playlist);
    }
}
