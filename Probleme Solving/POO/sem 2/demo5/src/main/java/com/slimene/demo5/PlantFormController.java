package com.slimene.demo5;


import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PlantFormController {

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSpecies;

    @FXML
    private ComboBox<String> fieldCategory;

    @FXML
    private Spinner<Integer> spinnerWater;

    @FXML
    private Spinner<Integer> spinnerFert;

    @FXML
    private DatePicker datePlanted;

    @FXML
    private void save() {
        System.out.println("Saved plant: " + fieldName.getText());
    }

    @FXML
    private void cancel() {
        fieldName.getScene().getWindow().hide();
    }
}