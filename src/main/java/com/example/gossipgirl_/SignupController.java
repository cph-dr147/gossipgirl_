package com.example.gossipgirl_;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private TextField emailField;
    @FXML private Label signupText;

    @FXML private Button backButton;   // 👈 ADD THIS

    private final UserDAO userDAO = new UserDAO();

    @FXML
    public void initialize() {
        // 🔥 FORCE enable (fixes cached disabled state)
        backButton.setDisable(false);
    }

    @FXML
    protected void onSignupButtonClick() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String email = emailField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            signupText.setText("Please fill in all fields!");
            return;
        }

        boolean success = userDAO.createUser(username, password, email);

        if (success) {
            signupText.setText("User created successfully! Please login.");
            ViewSwitcher.switchTo(View.LOGIN);
        } else {
            signupText.setText("Username already exists!");
        }
    }

    @FXML
    public void onBackButtonClick() {
        ViewSwitcher.switchTo(View.START);
    }
}
