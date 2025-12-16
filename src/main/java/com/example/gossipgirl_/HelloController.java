package com.example.gossipgirl_;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {

    private Stage getStage(ActionEvent event) {
        return (Stage) ((javafx.scene.Node) event.getSource())
                .getScene().getWindow();
    }

    public void onLogin(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/gossipgirl_/login-view.fxml")
        );
        getStage(event).setScene(new Scene(root));
    }

    public void onSignup(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/gossipgirl_/signup-view.fxml")
        );
        getStage(event).setScene(new Scene(root));
    }
}
