package com.example.springtemplate.daos;

import com.example.springtemplate.models.Song;
import com.example.springtemplate.repositories.SongRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongOrmDao {
    @Autowired
    // create an instance of the user
    SongRestRepository songRepository;                                          // repository and use it to implement
    // all these CRUD methods

    @GetMapping("/orm/songs/create/{fn}/{ln}/{un}/{pw}/{em}/{db}")
    // return the user inserted into the
    public Song createSong(@PathVariable("ti") String title,                    // database use parameters to create
                           @PathVariable("lg") Float length,                     // new user instance
                           @PathVariable("pb") Integer streams,
                           @PathVariable("ex") Boolean explicit,
                           @PathVariable("al") Integer album_id) {
        Song song = new Song(title, length, streams, explicit, album_id);       // using the constructor
        // insert into database and
        return songRepository.save(song);                                      // return resulting record

        // when using @GetMapping and @Path Variable,
        // access the resource through HTTP, pass parameters in path, parse path, variables, and pass as parameters
        // create instance, insert into database, and return new record
    }


    @GetMapping("/orm/songs/find")
    public List<Song> findAllSongs() {
        return songRepository.findAllSongs();
    }

    @GetMapping("/orm/songs/find/id/{songId}")
    public Song findSongById(
            @PathVariable("songId") Integer id) {
        return songRepository.findSongById(id);
    }

    @GetMapping("/orm/songs/delete/{songId}")
    public void deleteSong(@PathVariable("songId") Integer id) {                    // accept user's ID to be deleted
        songRepository.deleteById(id);                                              // use builtin deleteById method to
        // when @GetMapping and @PathVariable are used                              // remove record
        // encode user's ID at the end of the path
        // parse the user's ID from the path and pass as parameter
    }

    @GetMapping("/orm/songs/update/{songId}/{password}")
    public Song updateSong(@PathVariable("songId") Integer id, @PathVariable("title") String newTitle) {
        Song song = songRepository.findSongById(id);
        song.setTitle(newTitle);
        return songRepository.save(song);
    }
}
