package com.example.springtemplate.daos;

import com.example.springtemplate.models.Album;
import com.example.springtemplate.repositories.AlbumRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class AlbumOrmDao {
    @Autowired
    // create an instance of the album
    AlbumRestRepository albumRepository;                                          // repository and use it to implement
    // all these CRUD methods

    @GetMapping("/orm/albums/create/{fn}/{ln}/{un}/{pw}/{em}/{db}")                     // return the album inserted into the
    public Album createAlbum(@PathVariable("ti") String title,                    // database use parameters to create
                           @PathVariable("da") Date release_date,                     // new album instance
                           @PathVariable("ai") Integer artist_id)
    {
        Album album = new Album(title, release_date, artist_id);       // using the constructor
        // insert into database and
        return albumRepository.save(album);                                      // return resulting record

        // when using @GetMapping and @Path Variable,
        // access the resource through HTTP, pass parameters in path, parse path, variables, and pass as parameters
        // create instance, insert into database, and return new record
    }


    @GetMapping("/orm/albums/find")
    public List<Album> findAllAlbums() {
        return albumRepository.findAllAlbums();
    }

    @GetMapping("/orm/albums/find/id/{albumId}")
    public Album findAlbumById(
            @PathVariable("albumId") Integer id) {
        return albumRepository.findAlbumById(id);
    }

    @GetMapping("/orm/albums/delete/{albumId}")
    public void deleteAlbum(@PathVariable("albumId") Integer id) {                    // accept album's ID to be deleted
        albumRepository.deleteById(id);                                              // use builtin deleteById method to
        // when @GetMapping and @PathVariable are used                              // remove record
        // encode album's ID at the end of the path
        // parse the album's ID from the path and pass as parameter
    }

    @GetMapping("/orm/albums/update/{albumId}/{password}")
    public Album updateAlbum(@PathVariable("albumId") Integer id, @PathVariable("title") String newTitle) {
        Album album = albumRepository.findAlbumById(id);
        album.setTitle(newTitle);
        return albumRepository.save(album);
    }
}
