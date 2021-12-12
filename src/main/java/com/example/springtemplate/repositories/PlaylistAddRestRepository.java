package com.example.springtemplate.repositories;

import com.example.springtemplate.models.PlaylistAdd;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistAddRestRepository
        extends CrudRepository<PlaylistAdd, Integer> {
    @Query(value = "SELECT * FROM playlistadds",
            nativeQuery = true)
    public List<PlaylistAdd> findAllPlaylistAdds();
    @Query(value = "SELECT * FROM playlistadds WHERE id=:playlistaddId",
            nativeQuery = true)
    public PlaylistAdd findPlaylistAddById(@Param("playlistaddId") Integer id);
}
