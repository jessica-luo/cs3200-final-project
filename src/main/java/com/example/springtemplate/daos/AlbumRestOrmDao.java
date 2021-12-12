package com.example.springtemplate.daos;

import com.example.springtemplate.models.Album;
import com.example.springtemplate.repositories.AlbumRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AlbumRestOrmDao {
    @Autowired
    AlbumRestRepository albumRepository;

    @PostMapping("/api/albums")                          // map this method to an HTTP POST
    public Album createAlbum(@RequestBody Album album) {      // parse new album from HTTP Request BODY
        return albumRepository.save(album);                 // insert new album into album table
    }

    @GetMapping("/api/albums")                   // map this method to an HTTP GET request
    public List<Album> findAllAlbums() {            // execute this method if URL matches /api/albums
        return albumRepository.findAllAlbums();     // retrieve all records from albums table and return as list of albums
    }

    @GetMapping("/api/albums/{albumId}")              // map this method to HTTP GET request
    public Album findAlbumById(                         //  execute this method when URL matches /api/albums/ID
                                                        @PathVariable("albumId") Integer id) {         // parse album ID from path variable albumID
        return albumRepository.findAlbumById(id);       // retrieve single album by ID and return as instance of Album
    }

    @PutMapping("/api/albums/{albumId}")                          // map method to HTTP PUT
    public Album updateAlbum(
            @PathVariable("albumId") Integer id,                    // parse album's ID from URL
            @RequestBody Album albumUpdates) {                       // parse album object from BODY
        Album album = albumRepository.findAlbumById(id);               // retrieve album from database
        album.setTitle(albumUpdates.getTitle());             // update
        album.setReleaseDate(albumUpdates.getReleaseDate());               // album fields
        album.setArtistId(albumUpdates.getArtistId());               // with new
        return albumRepository.save(album);                          // save changes to database
    }

    @DeleteMapping("/api/albums/{albumId}")       // map this method to HTTP DELETE request
    public void deleteAlbum(                        // execute this method if URL matches /api/album/ID
                                                    @PathVariable("albumId") Integer id) {  // parse album's ID from path variable
        albumRepository.deleteById(id);              // use repository to permanently remove the album by their ID
    }
}