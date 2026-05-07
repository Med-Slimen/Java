package com.slimene.demo5;


import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UsersController {

    @FXML
    private TableView<?> usersTable;

    @FXML
    private void openAddUser() {
        System.out.println("Add user");
    }
}
