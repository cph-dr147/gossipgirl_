/*package com.example.gossipgirl_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Create a new user; returns true if successful, false if username exists
public class SignUpDAO {
    public boolean createUser(String username, String password, String email) {

        // 1. Validate input
        if (username == null || username.isBlank() ||
                password == null || password.isBlank() ||
                email == null || email.isBlank()) {
            return false;
        }

        String insertSql =
                "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";

        try {
            Connection conn = DBconnector.getConnection();

            try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                stmt.setString(1, username);
                stmt.setString(2, (password)); // IMPORTANT
                stmt.setString(3, email);
                stmt.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            // Username already exists (UNIQUE constraint)
            if (e.getMessage().contains("UNIQUE")) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }
}
*/


