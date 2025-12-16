package com.example.gossipgirl_;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GossipController {




    @FXML
    private TextArea chatDisplay;      // display (new)

    @FXML
    private TextArea gossipTextArea;



    private final PostDAO postDAO = new PostDAO();

    private int currentUserId;

    @FXML
    public void initialize() {

        User user = Session.getCurrentUser();

        if (user == null) {
            ViewSwitcher.switchTo(View.START);
            return;
        }

        currentUserId = user.getUserID();

//        try {
//            List<String> posts = postDAO.getAllPosts();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    @FXML
    private void onPeekatthesecretsButtonClick() {
        System.out.println("Peek button clicked");
    }

////    @FXML
////    public void onPeekatthesecretsButtonClick() {
////        try {
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//    }

@FXML
private void onSendGossip() {

    // 1. Get the message from input
    String message = gossipTextArea.getText().trim();
    if (message.isEmpty()) return;
    message = message + "\n\nxoxo gossip girl💋";
    postDAO.savePost(currentUserId, message);

    // 2. Get logged-in user, but sends messages as "anonymous"
    String author = "anonymous";

    // 3. Create timestamp
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String time = now.format(formatter);

    // 4. Display message
    chatDisplay.appendText(
            author + " • " + time + "\n" +
                    message + "\n\n"
    );

    // 5. Clear input
    gossipTextArea.clear();
}

    }


