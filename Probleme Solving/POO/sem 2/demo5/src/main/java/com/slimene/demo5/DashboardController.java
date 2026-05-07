package com.slimene.demo5;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblTotalPlants;

    @FXML
    private Label lblWateringToday;

    @FXML
    private Label lblAlerts;

    @FXML
    public void initialize() {
        // TEMP VALUES
        lblTotalPlants.setText("10");
        lblWateringToday.setText("3");
        lblAlerts.setText("1");
    }
}