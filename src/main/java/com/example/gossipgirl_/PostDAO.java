package com.example.gossipgirl_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    public List<String> getAllPosts() {
        List<String> posts = new ArrayList<>();

        String sql = """
                SELECT u.username, p.Message
                FROM Posts p
                JOIN Users u ON p.UserId = u.UserID
                ORDER BY PostId ASC
                """;

        try (Connection conn = DBconnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                posts.add(rs.getString("username") + ": " + rs.getString("message"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public void savePost(int userId, String message) {
        String sql = "INSERT INTO Posts (UserId, Message) VALUES (?, ?)";

        try (Connection conn = DBconnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setString(2, message);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
