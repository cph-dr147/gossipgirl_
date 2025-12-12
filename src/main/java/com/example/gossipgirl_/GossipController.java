package com.example.gossipgirl_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.List;

public class GossipController {

    @FXML
    private TextArea gossipTextArea;

    @FXML
    private ListView<String> gossipList;

    private int currentUserId = 1; // fx den loggede bruger

    // Korrekt initialize
    public void initialize() {
        try {
            List<String> posts = DAO.getAllPosts(); // prøv at hente beskeder
            if (posts != null) {
                gossipList.getItems().addAll(posts);
            }
        } catch (Exception e) {
            System.out.println("Ingen gamle beskeder eller DB ikke klar endnu.");
        }
    }

    @FXML
    public void onPeekatthesecretsButtonClick(ActionEvent actionEvent) {
        try {
            gossipList.getItems().clear();
            List<String> posts = DAO.getAllPosts();
            gossipList.getItems().addAll(posts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onSendGossip(ActionEvent actionEvent) {
        String message = gossipTextArea.getText().trim();

        if (!message.isEmpty()) {
            try {
                DAO.savePost(currentUserId, message);
                gossipList.getItems().add("You: " + message);
                gossipTextArea.clear();
                gossipList.scrollTo(gossipList.getItems().size() - 1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
