package com.example.gossipgirl_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {

    private static final String URL =
            "jdbc:sqlite:/Users/danarulle/Documents/java/gossipgirl_/gossipgirldatabase.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
            System.out.println("Connected to SQLite");
            System.out.println(conn.getMetaData().getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
