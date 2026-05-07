package com.slimene.demo5;



import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PlanningController {

    @FXML
    private TableView<?> planningTable;

    @FXML
    private void refreshPlanning() {
        System.out.println("Planning refreshed");
    }

    @FXML
    private void openAddTask() {
        System.out.println("Add task");
    }
}
