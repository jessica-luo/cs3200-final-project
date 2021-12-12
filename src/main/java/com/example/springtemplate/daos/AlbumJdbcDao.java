package com.example.springtemplate.daos;

import com.example.springtemplate.models.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumJdbcDao {
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
    String CREATE_ALBUM = "INSERT INTO albums VALUES (null, ?, ?, ?, null, null)";
    String FIND_ALL_ALBUMS = "SELECT * FROM albums";
    String FIND_ALBUM_BY_ID = "SELECT * FROM albums WHERE id=?";
    String DELETE_ALBUM = "DELETE FROM albums WHERE id=?";
    String UPDATE_ALBUM_TITLE = "UPDATE albums SET title=? WHERE id=?";
    String UPDATE_ALBUM = "UPDATE albums SET title=?, release_date=?, artist_id=? WHERE id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public Album findAlbumById(Integer id) throws SQLException, ClassNotFoundException {
        Album album = null;
        connection = getConnection();

        statement = connection.prepareStatement(FIND_ALBUM_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            album = new Album(
                    resultSet.getString("title"),
                    resultSet.getDate("release_date"),
                    resultSet.getInt("artist_id")
            );
        }

        closeConnection(connection);
        return album;
    }

    public Integer deleteAlbum(Integer albumId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(DELETE_ALBUM);
        statement.setInt(1, albumId);
        rowsDeleted = statement.executeUpdate();

        closeConnection(connection);
        return rowsDeleted;
    }

    public Integer updateAlbum(Integer albumId, Album newAlbum) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();

        statement = connection.prepareStatement(UPDATE_ALBUM);
        statement.setString(1, newAlbum.getTitle());
        statement.setDate(2, newAlbum.getReleaseDate());
        statement.setInt(3, newAlbum.getArtistId());
        statement.setInt(4, albumId);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;
    }

    public List<Album> findAllAlbums() throws ClassNotFoundException, SQLException {
        List<Album> albums = new ArrayList<Album>();
        connection = getConnection();

        statement = connection.prepareStatement(FIND_ALL_ALBUMS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Album album = new Album(
                    resultSet.getString("title"),
                    resultSet.getDate("release_date"),
                    resultSet.getInt("artist_id")
            );
            albums.add(album);
        }

        closeConnection(connection);
        return albums;
    }

    public Integer createAlbum(Album album)
            throws ClassNotFoundException, SQLException {
        Integer rowsInserted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(CREATE_ALBUM);
        statement.setString(1, album.getTitle());
        statement.setDate(2, album.getReleaseDate());
        statement.setInt(3, album.getArtistId());
        rowsInserted = statement.executeUpdate();

        closeConnection(connection);
        return rowsInserted;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AlbumJdbcDao dao = new AlbumJdbcDao();

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
