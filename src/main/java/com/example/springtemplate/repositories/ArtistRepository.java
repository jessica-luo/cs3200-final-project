package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    @Query(value = "SELECT * FROM artists", nativeQuery = true)                       // configure the SQL statement
    public List<Artist> findAllArtists();                                               // wrap SQL with Java interface
    @Query(value = "SELECT * FROM artists WHERE id=:artistId", nativeQuery = true)
    public Artist findArtistById(@Param("artistId") Integer id);
}
