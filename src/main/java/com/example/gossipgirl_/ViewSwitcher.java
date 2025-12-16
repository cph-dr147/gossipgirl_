package com.example.gossipgirl_;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewSwitcher {

    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void switchTo(View view) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    ViewSwitcher.class.getResource(
                            "/com/example/gossipgirl_/" + view.getFileName()
                    )
            );

            Parent root = loader.load();
            stage.setScene(new Scene(root));

        } catch (Exception e) {
            System.out.println("❌ Failed to load view: " + view);
            e.printStackTrace();
        }
    }
}
