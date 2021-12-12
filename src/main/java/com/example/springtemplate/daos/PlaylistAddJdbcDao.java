package com.example.springtemplate.daos;

import com.example.springtemplate.models.PlaylistAdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistAddJdbcDao {
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
    String CREATE_PLAYLISTADD = "INSERT INTO playlistadds VALUES (null, ?, null, null, ?, ?)";
    String FIND_ALL_PLAYLISTADDS = "SELECT * FROM playlistadds";
    String FIND_PLAYLISTADD_BY_ID = "SELECT * FROM playlistadds WHERE id=?";
    String DELETE_PLAYLISTADD = "DELETE FROM playlistadds WHERE id=?";
    String UPDATE_PLAYLISTADD_TITLE = "UPDATE playlistadds SET title=? WHERE id=?";
    String UPDATE_PLAYLISTADD = "UPDATE playlistadds SET rationale=?, song_id=?, playlist_id=? WHERE id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public PlaylistAdd findPlaylistAddById(Integer id) throws SQLException, ClassNotFoundException {
        PlaylistAdd playlistadd = null;
        connection = getConnection();

        statement = connection.prepareStatement(FIND_PLAYLISTADD_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            playlistadd = new PlaylistAdd(
                    resultSet.getString("rationale"),
                    resultSet.getInt("song_id"),
                    resultSet.getInt("playlist_id")
            );
        }

        closeConnection(connection);
        return playlistadd;
    }

    public Integer deletePlaylistAdd(Integer playlistaddId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(DELETE_PLAYLISTADD);
        statement.setInt(1, playlistaddId);
        rowsDeleted = statement.executeUpdate();

        closeConnection(connection);
        return rowsDeleted;
    }

    public Integer updatePlaylistAdd(Integer playlistaddId, PlaylistAdd newPlaylistAdd) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();

        statement = connection.prepareStatement(UPDATE_PLAYLISTADD);
        statement.setString(1, newPlaylistAdd.getRationale());
        statement.setInt(2, newPlaylistAdd.getSong_id());
        statement.setInt(3, newPlaylistAdd.getPlaylist_id());
        statement.setInt(4, playlistaddId);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;
    }

    public List<PlaylistAdd> findAllPlaylistAdds() throws ClassNotFoundException, SQLException {
        List<PlaylistAdd> playlistadds = new ArrayList<PlaylistAdd>();
        connection = getConnection();

        statement = connection.prepareStatement(FIND_ALL_PLAYLISTADDS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            PlaylistAdd playlistadd = new PlaylistAdd(
                    resultSet.getString("rationale"),
                    resultSet.getInt("song_id"),
                    resultSet.getInt("playlist_id")
            );
            playlistadds.add(playlistadd);
        }

        closeConnection(connection);
        return playlistadds;
    }

    public Integer createPlaylistAdd(PlaylistAdd playlistadd)
            throws ClassNotFoundException, SQLException {
        Integer rowsInserted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(CREATE_PLAYLISTADD);
        statement.setString(1, playlistadd.getRationale());
        statement.setInt(2, playlistadd.getSong_id());
        statement.setInt(3, playlistadd.getPlaylist_id());
        rowsInserted = statement.executeUpdate();

        closeConnection(connection);
        return rowsInserted;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PlaylistAddJdbcDao dao = new PlaylistAddJdbcDao();


//        // -- to test createPlaylistAdds --
//        PlaylistAdd thirty =
//                new PlaylistAdd("test", 1, 1);
//        dao.createPlaylistAdd(thirty);

//
//
//        // -- to test findAllPlaylistAdds --
//        List<PlaylistAdd> playlistadds = dao.findAllPlaylistAdds();
//        for(PlaylistAdd playlistadd: playlistadds) {
//            System.out.println(playlistadd.getRationale());
//        }
//
//
//
//
        // -- to test findPlaylistAddById --
//        PlaylistAdd playlistadd = dao.findPlaylistAddById(1);
//        System.out.println(playlistadd.getRationale());
//
//
//
//        //  -- to test deletePlaylistAdd --
//        dao.deletePlaylistAdd(20);
//        List<PlaylistAdd> playlistadds = dao.findAllPlaylistAdds();
//        for (PlaylistAdd playlistadd: playlistadds) {
//            System.out.println(playlistadd.getRationale());
//        }
//
//
//        // -- to test updatePlaylistAdd --
//
//        PlaylistAdd testPlaylistAdd = new PlaylistAdd("TestPlaylistAdd", 1, 1);
//        dao.createPlaylistAdd(testPlaylistAdd);
//        dao.updatePlaylistAdd(21, testPlaylistAdd);



    }
}
