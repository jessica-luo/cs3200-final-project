package com.example.springtemplate.daos;

import com.example.springtemplate.models.User;

import java.sql.*;
import java.util.*;

public class UserJdbcDao {
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
    String CREATE_USER = "INSERT INTO users VALUES (null, ?, ?, ?, ?, ?, ?, null, null)";
    String FIND_ALL_USERS = "SELECT * FROM users";
    String FIND_USER_BY_ID = "SELECT * FROM users WHERE id=?";
    String DELETE_USER = "DELETE FROM users WHERE id=?";
    String UPDATE_USER_EMAIL = "UPDATE users SET email=? WHERE id=?";
    String UPDATE_USER = "UPDATE users SET firstname=?, lastname=?, username=?, password=?, email=?, dateOfBirth=? WHERE id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public User findUserById(Integer id) throws SQLException, ClassNotFoundException {
        User user = null;
        connection = getConnection();

        statement = connection.prepareStatement(FIND_USER_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            user = new User(
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getDate("date_of_birth")
            );
        }

        closeConnection(connection);
        return user;
    }

    public Integer deleteUser(Integer userId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(DELETE_USER);
        statement.setInt(1, userId);
        rowsDeleted = statement.executeUpdate();

        closeConnection(connection);
        return rowsDeleted;
    }

    public Integer updateUser(Integer userId, User newUser) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();

        statement = connection.prepareStatement(UPDATE_USER);
        statement.setString(1, newUser.getFirstName());
        statement.setString(2, newUser.getLastName());
        statement.setString(3, newUser.getUsername());
        statement.setString(4, newUser.getPassword());
        statement.setString(5, newUser.getEmail());
        statement.setDate(6, newUser.getDateOfBirth());
        statement.setInt(7, userId);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;
    }

    public List<User> findAllUsers() throws ClassNotFoundException, SQLException {
        List<User> users = new ArrayList<User>();
        connection = getConnection();

        statement = connection.prepareStatement(FIND_ALL_USERS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getDate("date_of_birth")
            );
            users.add(user);
        }

        closeConnection(connection);
        return users;
    }

    public Integer createUser(User user)
            throws ClassNotFoundException, SQLException {
        Integer rowsInserted = 0;
        connection = getConnection();

        statement = connection.prepareStatement(CREATE_USER);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getEmail());
        statement.setDate(6, user.getDateOfBirth());
        rowsInserted = statement.executeUpdate();

        closeConnection(connection);
        return rowsInserted;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserJdbcDao dao = new UserJdbcDao();

        // -- to test createUser --

//        User kelly =
//                new User("Kelly", "Ward", "kellyw19",
//                        "cs3200", "ward.kelly1@northeastern.edu", java.sql.Date.valueOf("2001-01-19"));
//        User jessica =
//                new User("Jessica", "Luo", "jluo",
//                        "qwertyuiop", "luo.jes@northeastern.edu", java.sql.Date.valueOf("2001-12-08"));
//        User hannah =
//                new User("Hannah", "Lauterwasser", "hlauterwasser",
//                        "1234", "lauterwasser.h@northeastern.edu", java.sql.Date.valueOf("1999-04-15"));
//        dao.createUser(kelly);
//        dao.createUser(jessica);
//        dao.createUser(hannah);


//        // -- to test findAllUsers --
//        List<User> users = dao.findAllUsers();
//        for(User user: users) {
//            System.out.println(user.getDateOfBirth());
//        }

/*
        // -- to test findUserById --
        User user = dao.findUserById(1);
        System.out.println(user.getUsername());


        //  -- to test deleteUser --
        dao.deleteUser(1);
        List<User> users = dao.findAllUsers();
        for (User user: users) {
            System.out.println(user.getUsername());
        }


        // -- to test updateUser --

        User testUser =
                new User("Test", "User", "testuser",
                        "cs3200", "user.test@northeastern.edu", java.sql.Date.valueOf("2001-01-01"));
        dao.createUser(testUser);
        User newTestUser = new User(
                "Test",
                "User",
                "best_test_user",
                "cs3200",
                "user.test@nortehastern.edu",
                java.sql.Date.valueOf("2001-01-01"));
        dao.updateUser(13, newTestUser);
        User kelly = dao.findUserById(10);
        System.out.println(kelly.getUsername());
        */

    }
}
