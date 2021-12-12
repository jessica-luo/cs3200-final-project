package com.example.springtemplate.daos;

import com.example.springtemplate.models.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistJdbcDao {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String HOST = "localhost:3306";
    static final String SCHEMA = "db_final_project";
    static final String CONFIG = "serverTimezone=UTC";
    static final String URL =
            "jdbc:mysql://" + HOST + "/" + SCHEMA + "?" + CONFIG;
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    static Connection connection = null;
    static PreparedStatement statement = null;
    String CREATE_PLAYLIST = "INSERT INTO playlists VALUES (null, ?, ?, ?, null, null, ?)";
    String FIND_ALL_PLAYLISTS = "SELECT * FROM playlists";
    String FIND_PLAYLIST_BY_ID = "SELECT * FROM playlists WHERE id=?";
    String DELETE_PLAYLIST = "DELETE FROM playlists WHERE id=?";
    String UPDATE_PLAYLIST = "UPDATE playlists SET name=?, likes=?, public=?, user_id=? WHERE id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public Playlist findPlaylistById(Integer id) throws SQLException, ClassNotFoundException {
        Playlist playlist = null;
        connection = getConnection();

        statement = connection.prepareStatement(FIND_PLAYLIST_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            playlist = new Playlist(
                    resultSet.getString("name"),
                    resultSet.getInt("likes"),
                    resultSet.getBoolean("public"),
                    resultSet.getInt("user_id")
            );
        }

        closeConnection(connection);
        return playlist;
    }

    public Integer deletePlaylist(Integer playlistId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(DELETE_PLAYLIST);
        statement.setInt(1, playlistId);
        rowsDeleted = statement.executeUpdate();

        closeConnection(connection);
        return rowsDeleted;
    }

    public Integer updatePlaylist(Integer playlistId, Playlist newPlaylist) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();

        statement = connection.prepareStatement(UPDATE_PLAYLIST);
        statement.setString(1, newPlaylist.getName());
        statement.setInt(2, newPlaylist.getLikes());
        statement.setBoolean(3, newPlaylist.getPub());
        statement.setInt(4, newPlaylist.getUserId());
        statement.setInt(5, playlistId);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;
    }

    public List<Playlist> findAllPlaylists() throws ClassNotFoundException, SQLException {
        List<Playlist> playlists = new ArrayList<Playlist>();
        connection = getConnection();

        statement = connection.prepareStatement(FIND_ALL_PLAYLISTS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Playlist playlist = new Playlist(
                    resultSet.getString("name"),
                    resultSet.getInt("likes"),
                    resultSet.getBoolean("public"),
                    resultSet.getInt("user_id")
            );
            playlists.add(playlist);
        }

        closeConnection(connection);
        return playlists;
    }

    public Integer createPlaylist(Playlist playlist)
            throws ClassNotFoundException, SQLException {
        Integer rowsInserted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(CREATE_PLAYLIST);
        statement.setString(1, playlist.getName());
        statement.setInt(2, playlist.getLikes());
        statement.setBoolean(3, playlist.getPub());
        statement.setInt(4, playlist.getUserId());
        rowsInserted = statement.executeUpdate();

        closeConnection(connection);
        return rowsInserted;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PlaylistJdbcDao dao = new PlaylistJdbcDao();

        // -- to test createAlbums --
//
//        Playlist christmas = new Playlist("Christmas", 0, true, 1);
//
//        dao.createPlaylist(christmas);

        /*
        // -- to test createAlbums --
        Album thirty =
                new Album("30", java.sql.Date.valueOf("2021-11-19"), 13);
        Album opera =
                new Album("A Night at the Opera", java.sql.Date.valueOf("1975-11-06"), 8);
        Album red =
                new Album("Red (Taylor's Version", java.sql.Date.valueOf("2021-11-19"), 6);

        dao.createAlbum(thirty);
        dao.createAlbum(opera);
        dao.createAlbum(red);


        // -- to test findAllAlbums --
        List<Album> albums = dao.findAllAlbums();
        for(Album album: albums) {
            System.out.println(album.getTitle());
        }



        /*
        // -- to test findAlbumById --
        Album album = dao.findAlbumById(1);
        System.out.println(album.getTitle());



        //  -- to test deleteAlbum --
        dao.deleteAlbum(1);
        List<Album> albums = dao.findAllAlbums();
        for (Album album: albums) {
            System.out.println(album.getTitle());
        }


        // -- to test updateAlbum --

        Album testAlbum = new Album("TestAlbum", java.sql.Date.valueOf("2021-11-19"), 1);
        dao.createAlbum(testAlbum);
        Album newTestAlbum = new Album("BestTestAlbum", java.sql.Date.valueOf("2001-01-01"), 1);
        dao.updateAlbum(14, newTestAlbum);

        */

    }
}
