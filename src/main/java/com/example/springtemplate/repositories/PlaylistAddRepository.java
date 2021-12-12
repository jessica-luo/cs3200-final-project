package com.example.springtemplate.repositories;

import com.example.springtemplate.models.PlaylistAdd;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistAddRepository extends CrudRepository<PlaylistAdd, Integer> {
    @Query(value = "SELECT * FROM playlistadds", nativeQuery = true)                       // configure the SQL statement
    public List<PlaylistAdd> findAllPlaylistAdds();                                               // wrap SQL with Java interface
    @Query(value = "SELECT * FROM playlistadds WHERE id=:playlistaddId", nativeQuery = true)
    public PlaylistAdd findPlaylistAddById(@Param("playlistaddId") Integer id);
}
