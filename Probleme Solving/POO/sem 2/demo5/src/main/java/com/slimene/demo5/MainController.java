package com.slimene.demo5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;

public class MainController {

    @FXML
    private StackPane contentArea;

    private void loadView(String fxml) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource("/fxml/" + fxml));
            contentArea.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showDashboard() {
        loadView("DashboardView.fxml");
    }

    @FXML
    private void showPlants() {
        loadView("PlantsView.fxml");
    }

    @FXML
    private void showPlanning() {
        loadView("PlanningView.fxml");
    }

    @FXML
    private void showGardens() {
        loadView("GardensView.fxml");
    }

    @FXML
    private void showAlerts() {
        loadView("AlertsView.fxml");
    }

    @FXML
    private void showUsers() {
        loadView("UsersView.fxml");
    }

    @FXML
    private void logout() {
        loadView("LoginView.fxml");
    }
}
