package com.example.springtemplate.daos;

import com.example.springtemplate.models.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongJdbcDao {
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
    String CREATE_SONG = "INSERT INTO songs VALUES (null, ?, ?, ?, ?, ?, null, null)";
    String FIND_ALL_SONGS = "SELECT * FROM songs";
    String FIND_SONG_BY_ID = "SELECT * FROM songs WHERE id=?";
    String DELETE_SONG = "DELETE FROM songs WHERE id=?";
    String UPDATE_SONG = "UPDATE songs SET title=?, length=?, streams=?, explicit=?, album_id=? WHERE id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public Song findSongById(Integer id) throws SQLException, ClassNotFoundException {
        Song song = null;
        connection = getConnection();

        statement = connection.prepareStatement(FIND_SONG_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            song = new Song(
                    resultSet.getString("title"),
                    resultSet.getFloat("length"),
                    resultSet.getInt("streams"),
                    resultSet.getBoolean("explicit"),
                    resultSet.getInt("album_id")
            );
        }

        closeConnection(connection);
        return song;
    }

    public Integer deleteSong(Integer songId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(DELETE_SONG);
        statement.setInt(1, songId);
        rowsDeleted = statement.executeUpdate();

        closeConnection(connection);
        return rowsDeleted;
    }

    public Integer updateSong(Integer songId, Song newSong) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();

        statement = connection.prepareStatement(UPDATE_SONG);
        statement.setString(1, newSong.getTitle());
        statement.setFloat(2, newSong.getLength());
        statement.setInt(3, newSong.getStreams());
        statement.setBoolean(4, newSong.getExplicit());
        statement.setInt(5, newSong.getAlbum_id());
        statement.setInt(6, songId);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;
    }

    public List<Song> findAllSongs() throws ClassNotFoundException, SQLException {
        List<Song> songs = new ArrayList<Song>();
        connection = getConnection();

        statement = connection.prepareStatement(FIND_ALL_SONGS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Song song = new Song(
                    resultSet.getString("title"),
                    resultSet.getFloat("length"),
                    resultSet.getInt("streams"),
                    resultSet.getBoolean("explicit"),
                    resultSet.getInt("album_id")
            );
            songs.add(song);
        }

        closeConnection(connection);
        return songs;
    }

    public Integer createSong(Song song)
            throws ClassNotFoundException, SQLException {
        Integer rowsInserted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(CREATE_SONG);
        statement.setString(1, song.getTitle());
        statement.setFloat(2, song.getLength());
        statement.setInt(3, song.getStreams());
        statement.setBoolean(4, song.getExplicit());
        statement.setInt(5, song.getAlbum_id());
        rowsInserted = statement.executeUpdate();

        closeConnection(connection);
        return rowsInserted;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SongJdbcDao dao = new SongJdbcDao();


//       Song gooey = new Song("Gooey", 4.0F, 250000000, true, 1);
//
//       dao.createSong(gooey);


        // -- to test createAlbums --
//        Album thirty =
//                new Album("30", java.sql.Date.valueOf("2021-11-19"), 13);
//        Album opera =
//                new Album("A Night at the Opera", java.sql.Date.valueOf("1975-11-06"), 8);
//        Album red =
//                new Album("Red (Taylor's Version", java.sql.Date.valueOf("2021-11-19"), 6);
//
//        dao.createAlbum(thirty);
//        dao.createAlbum(opera);
//        dao.createAlbum(red);


        // -- to test findAllAlbums --
//        List<Song> albums = dao.findAllSongs();
//        for(Song album: albums) {
//            System.out.println(album.getTitle());
//        }




        // -- to test findAlbumById --
//        Song album = dao.findSongById(44);
//        System.out.println(album.getTitle());



        //  -- to test deleteAlbum --
//        dao.deleteSong(44);
//        List<Song> albums = dao.findAllSongs();
//        for (Song album: albums) {
//            System.out.println(album.getTitle());
//        }


        // -- to test updateAlbum --

//        Album testAlbum = new Album("TestAlbum", java.sql.Date.valueOf("2021-11-19"), 1);
//        dao.createAlbum(testAlbum);
//        Song newTestAlbum = new Song("Gooey", 4.5F, 250000000, false, 1);
//        dao.updateSong(45, newTestAlbum);


    }
}
