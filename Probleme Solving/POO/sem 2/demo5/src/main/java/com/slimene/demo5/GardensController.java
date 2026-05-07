package com.slimene.demo5;


import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;

public class GardensController {

    @FXML
    private TilePane gardensGrid;

    @FXML
    public void initialize() {
        System.out.println("Gardens loaded");
    }

    @FXML
    private void openAddGarden() {
        System.out.println("Add garden");
    }
}