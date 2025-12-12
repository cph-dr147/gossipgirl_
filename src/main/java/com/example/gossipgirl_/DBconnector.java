package com.example.gossipgirl_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnector {

    private static final String URL = "jdbc:sqlite:console.sql";
    //"jdbc:sqlite:gossip.db";
   // private static final String URL = "jdbc:sqlite:console.sql";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL);
                System.out.println("Connected to SQLite");
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e.getMessage());
            }
        }
        return connection;
    }
}
