package com.example.springtemplate.daos;

import com.example.springtemplate.models.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistJdbcDao {
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
    String CREATE_ARTIST = "INSERT INTO artists VALUES (null, ?, ?, null, null)";
    String FIND_ALL_ARTISTS = "SELECT * FROM artists";
    String FIND_ARTIST_BY_ID = "SELECT * FROM artists WHERE id=?";
    String DELETE_ARTIST = "DELETE FROM artists WHERE id=?";
    String UPDATE_ARTIST = "UPDATE artists SET name=?, genre=? WHERE id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public Artist findArtistById(Integer id) throws SQLException, ClassNotFoundException {
        Artist artist = null;
        connection = getConnection();

        statement = connection.prepareStatement(FIND_ARTIST_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            artist = new Artist(
                    resultSet.getString("name"),
                    resultSet.getInt("genre")
            );
        }

        closeConnection(connection);
        return artist;
    }

    public Integer deleteArtist(Integer artistId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(DELETE_ARTIST);
        statement.setInt(1, artistId);
        rowsDeleted = statement.executeUpdate();

        closeConnection(connection);
        return rowsDeleted;
    }

    public Integer updateArtist(Integer artistId, Artist newArtist) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();

        statement = connection.prepareStatement(UPDATE_ARTIST);
        statement.setString(1, newArtist.getName());
        statement.setInt(2, newArtist.getGenre());
        statement.setInt(3, artistId);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;
    }

    public List<Artist> findAllArtists() throws ClassNotFoundException, SQLException {
        List<Artist> artists = new ArrayList<Artist>();
        connection = getConnection();

        statement = connection.prepareStatement(FIND_ALL_ARTISTS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Artist artist = new Artist(
                    resultSet.getString("name"),
                    resultSet.getInt("genre")
            );
            artists.add(artist);
        }

        closeConnection(connection);
        return artists;
    }

    public Integer createArtist(Artist artist)
            throws ClassNotFoundException, SQLException {
        Integer rowsInserted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(CREATE_ARTIST);
        statement.setString(1, artist.getName());
        statement.setInt(2, artist.getGenre());
        rowsInserted = statement.executeUpdate();

        closeConnection(connection);
        return rowsInserted;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArtistJdbcDao dao = new ArtistJdbcDao();


        // -- to test createArtists --
//        Artist GA =
//                new Artist("Glass Animals", 1);
//        dao.createArtist(GA);

//        Artist opera =
//                new Artist("A Night at the Opera", java.sql.Date.valueOf("1975-11-06"), 8);
//        Artist red =
//                new Artist("Red (Taylor's Version", java.sql.Date.valueOf("2021-11-19"), 6);
//
//
//        dao.createArtist(opera);
//        dao.createArtist(red);


        // -- to test findAllArtists --
//        List<Artist> artists = dao.findAllArtists();
//        for(Artist artist: artists) {
//            System.out.println(artist.getName());
//        }


        // -- to test findArtistById --
//        Artist artist = dao.findArtistById(1);
//        System.out.println(artist.getName());


        //  -- to test deleteArtist --
//        dao.deleteArtist(20);
//        List<Artist> artists = dao.findAllArtists();
//        for (Artist artist: artists) {
//            System.out.println(artist.getName());
//        }


        // -- to test updateArtist --

//        Artist testArtist = new Artist("Glass Animals", 2);
//        dao.updateArtist(21, testArtist);


    }
}
