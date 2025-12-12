package com.example.gossipgirl_;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static void savePost(int userId, String message) throws SQLException {
        String sql = "INSERT INTO posts(user_id, message) VALUES(?, ?)";
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        pstmt.setString(2, message);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public static List<String> getAllPosts() throws SQLException {
        List<String> posts = new ArrayList<>();
        String sql = "SELECT message FROM posts ORDER BY timestamp ASC";
        Connection conn = DBConnector.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            posts.add(rs.getString("message"));
        }

        rs.close();
        stmt.close();
        return posts;
    }
}