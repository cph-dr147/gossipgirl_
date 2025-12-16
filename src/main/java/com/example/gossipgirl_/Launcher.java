package com.example.gossipgirl_;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        DBconnector.initializeDatabase();

        ViewSwitcher.setStage(stage);

        ViewSwitcher.switchTo(View.START);

        stage.setTitle("Gossip Girl");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
