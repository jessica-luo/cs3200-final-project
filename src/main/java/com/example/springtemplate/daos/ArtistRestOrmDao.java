package com.example.springtemplate.daos;

import com.example.springtemplate.models.Artist;
import com.example.springtemplate.repositories.ArtistRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ArtistRestOrmDao {
    @Autowired
    ArtistRestRepository artistRepository;

    @PostMapping("/api/artists")                          // map this method to an HTTP POST
    public Artist createArtist(@RequestBody Artist artist) {      // parse new artist from HTTP Request BODY
        return artistRepository.save(artist);                 // insert new artist into artist table
    }

    @GetMapping("/api/artists")                   // map this method to an HTTP GET request
    public List<Artist> findAllArtists() {            // execute this method if URL matches /api/artists
        return artistRepository.findAllArtists();     // retrieve all records from artists table and return as list of artists
    }

    @GetMapping("/api/artists/{artistId}")              // map this method to HTTP GET request
    public Artist findArtistById(@PathVariable("artistId") Integer id) {
        return artistRepository.findArtistById(id);       // retrieve single artist by ID and return as instance of Artist
    }

    @PutMapping("/api/artists/{artistId}")                          // map method to HTTP PUT
    public Artist updateArtist(
            @PathVariable("artistId") Integer id,                    // parse artist's ID from URL
            @RequestBody Artist artistUpdates) {                       // parse artist object from BODY
        Artist artist = artistRepository.findArtistById(id);               // retrieve artist from database
        artist.setName(artistUpdates.getName());             // update
        artist.setGenre(artistUpdates.getGenre());               // artist fields         // with new
        return artistRepository.save(artist);                          // save changes to database
    }

    @DeleteMapping("/api/artists/{artistId}")       // map this method to HTTP DELETE request
    public void deleteArtist(                        // execute this method if URL matches /api/artist/ID
                                                     @PathVariable("artistId") Integer id) {  // parse artist's ID from path variable
        artistRepository.deleteById(id);              // use repository to permanently remove the artist by their ID
    }
}