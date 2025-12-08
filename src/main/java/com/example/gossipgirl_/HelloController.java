package com.example.gossipgirl_;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onLoginButtonClick() {
        welcomeText.setText("login");
        ViewSwitcher.switchTo(View.LOGIN);

    }

    @FXML
    protected void onSignupButtonClick() {
        welcomeText.setText("signup");
        ViewSwitcher.switchTo(View.SIGNUP);

    }
}
