package com.example.gossipgirl_;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // ✅ Connect to SQLite at startup
        DBConnector.getConnection();
        System.out.println(new java.io.File("console.sql").getAbsolutePath());

        // Load FXML and create scene
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");

        // Use your ViewSwitcher logic
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.START);

        stage.setScene(scene);
        stage.show();
    }
}
