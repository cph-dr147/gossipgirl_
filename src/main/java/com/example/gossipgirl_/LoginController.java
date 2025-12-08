package com.example.gossipgirl_;

import com.example.gossipgirl_.View;
import com.example.gossipgirl_.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController {
    @FXML
    private Label loginText;

    @FXML
    protected void onLoginButtonClick() {
        boolean login = true;
        if (!login) {
            loginText.setText("incorrect username or password");
        }
        else {
            ViewSwitcher.switchTo(View.MAIN);
        }
    }
}