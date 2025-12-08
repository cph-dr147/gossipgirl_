package com.example.gossipgirl_;

import com.example.gossipgirl_.View;
import com.example.gossipgirl_.ViewSwitcher;
import javafx.fxml.FXML;

public class SignupController {
    @FXML
    protected void onSignupButtonClick() {

        ViewSwitcher.switchTo(View.START);
    }
}