package com.example.springtemplate.daos;

import com.example.springtemplate.models.PlaylistAdd;
import com.example.springtemplate.repositories.PlaylistAddRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class PlaylistAddOrmDao {
    @Autowired
    // create an instance of the playlistadd
    PlaylistAddRestRepository playlistaddRepository;                                          // repository and use it to implement
    // all these CRUD methods

    @GetMapping("/orm/playlistadds/create/{fn}/{ln}/{un}/{pw}/{em}/{db}")                     // return the playlistadd inserted into the
    public PlaylistAdd createPlaylistAdd(@PathVariable("ti") String rationale,                    // database use parameters to create
                           @PathVariable("da") Integer song_id,                     // new playlistadd instance
                           @PathVariable("ai") Integer playlist_id)
    {
        PlaylistAdd playlistadd = new PlaylistAdd(rationale, song_id, playlist_id);       // using the constructor
        // insert into database and
        return playlistaddRepository.save(playlistadd);                                      // return resulting record

        // when using @GetMapping and @Path Variable,
        // access the resource through HTTP, pass parameters in path, parse path, variables, and pass as parameters
        // create instance, insert into database, and return new record
    }


    @GetMapping("/orm/playlistadds/find")
    public List<PlaylistAdd> findAllPlaylistAdds() {
        return playlistaddRepository.findAllPlaylistAdds();
    }

    @GetMapping("/orm/playlistadds/find/id/{playlistaddId}")
    public PlaylistAdd findPlaylistAddById(
            @PathVariable("playlistaddId") Integer id) {
        return playlistaddRepository.findPlaylistAddById(id);
    }

    @GetMapping("/orm/playlistadds/delete/{playlistaddId}")
    public void deletePlaylistAdd(@PathVariable("playlistaddId") Integer id) {                    // accept playlistadd's ID to be deleted
        playlistaddRepository.deleteById(id);                                              // use builtin deleteById method to
        // when @GetMapping and @PathVariable are used                              // remove record
        // encode playlistadd's ID at the end of the path
        // parse the playlistadd's ID from the path and pass as parameter
    }

    @GetMapping("/orm/playlistadds/update/{playlistaddId}/{password}")
    public PlaylistAdd updatePlaylistAdd(@PathVariable("playlistaddId") Integer id, @PathVariable("rationale") String newTitle) {
        PlaylistAdd playlistadd = playlistaddRepository.findPlaylistAddById(id);
        playlistadd.setRationale(newTitle);
        return playlistaddRepository.save(playlistadd);
    }
}
