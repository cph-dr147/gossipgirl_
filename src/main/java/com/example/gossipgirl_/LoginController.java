package com.example.gossipgirl_;

import com.example.gossipgirl_.View;
import com.example.gossipgirl_.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Label loginText;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    protected void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = userDAO.loginUser(username, password);

        if (user == null) {
            loginText.setText("Incorrect username or password");
        } else {
            loginText.setText("Welcome ");
            Session.setCurrentUser(user);
            ViewSwitcher.switchTo(View.MAIN);
        }
    }
    public void onBackButtonClick() {
        ViewSwitcher.switchTo(View.START);
    }


    private Stage getStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();
    }

    public void onBackButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/gossipgirl_/hello-view.fxml")
        );
        getStage(event).setScene(new Scene(root));
    }
}
