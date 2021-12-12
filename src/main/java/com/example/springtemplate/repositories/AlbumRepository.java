package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
    @Query(value = "SELECT * FROM albums", nativeQuery = true)                       // configure the SQL statement
    public List<Album> findAllAlbums();                                               // wrap SQL with Java interface
    @Query(value = "SELECT * FROM albums WHERE id=:albumId", nativeQuery = true)
    public Album findAlbumById(@Param("albumId") Integer id);
}
