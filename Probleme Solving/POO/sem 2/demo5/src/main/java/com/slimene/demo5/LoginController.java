package com.slimene.demo5;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class LoginController {

    @FXML
    private TextField fieldEmail;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Label lblError;

    @FXML
    private void login() {
        String email = fieldEmail.getText();
        String password = fieldPassword.getText();

        // TEMP (replace with DB check)
        if (email.equals("admin@gmail.com") && password.equals("1234")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
                Stage stage = (Stage) fieldEmail.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            lblError.setText("Email ou mot de passe incorrect");
        }
    }

    @FXML
    private void goRegister() {
        lblError.setText("Inscription non implémentée");
    }
}