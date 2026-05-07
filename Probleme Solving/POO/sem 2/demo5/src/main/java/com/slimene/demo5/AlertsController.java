package com.slimene.demo5;


import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AlertsController {

    @FXML
    private TableView<?> alertsTable;

    @FXML
    private void syncWeather() {
        System.out.println("Weather synced");
    }

    @FXML
    private void openAddAlert() {
        System.out.println("Add alert");
    }
}