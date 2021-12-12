package com.example.springtemplate.daos;

import com.example.springtemplate.models.Artist;
import com.example.springtemplate.models.Genre;
import com.example.springtemplate.repositories.ArtistRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistOrmDao {
    @Autowired
    // create an instance of the artist
    ArtistRestRepository artistRepository;                                          // repository and use it to implement
    // all these CRUD methods

    @GetMapping("/orm/artists/create/{fn}/{ln}/{un}/{pw}/{em}/{db}")
    // return the artist inserted into the
    public Artist createArtist(@PathVariable("nm") String name,                    // database use parameters to create
                               @PathVariable("ge") Integer genre)                   // new artist instance
    {
        Artist artist = new Artist(name, genre);       // using the constructor
        // insert into database and
        return artistRepository.save(artist);                                      // return resulting record

        // when using @GetMapping and @Path Variable,
        // access the resource through HTTP, pass parameters in path, parse path, variables, and pass as parameters
        // create instance, insert into database, and return new record
    }


    @GetMapping("/orm/artists/find")
    public List<Artist> findAllArtists() {
        return artistRepository.findAllArtists();
    }

    @GetMapping("/orm/artists/find/id/{artistId}")
    public Artist findArtistById(
            @PathVariable("artistId") Integer id) {
        return artistRepository.findArtistById(id);
    }

    @GetMapping("/orm/artists/delete/{artistId}")
    public void deleteArtist(@PathVariable("artistId") Integer id) {                    // accept artist's ID to be deleted
        artistRepository.deleteById(id);                                              // use builtin deleteById method to
        // when @GetMapping and @PathVariable are used                              // remove record
        // encode artist's ID at the end of the path
        // parse the artist's ID from the path and pass as parameter
    }

    @GetMapping("/orm/artists/update/{artistId}/{password}")
    public Artist updateArtist(@PathVariable("artistId") Integer id, @PathVariable("name") String newName) {
        Artist artist = artistRepository.findArtistById(id);
        artist.setName(newName);
        return artistRepository.save(artist);
    }
}
