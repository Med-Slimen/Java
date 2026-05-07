package com.slimene.demo5;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

public class PlantsController {

    @FXML
    private TableView<Plant> plantsTable;

    @FXML
    private TableColumn<Plant, Integer> colId;

    @FXML
    private TableColumn<Plant, String> colName;

    @FXML
    private TableColumn<Plant, String> colSpecies;

    @FXML
    private TextField searchField;
    private PlantDAO plantDAO = new PlantDAO();
    private ObservableList<Plant> plantList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        colName.setCellValueFactory(data -> data.getValue().nameProperty());
        colSpecies.setCellValueFactory(data -> data.getValue().speciesProperty());

        loadPlants();
    }

    private void loadPlants() {
        // TEMP DATA (replace with DAO)
        plantList.clear();
        plantList.addAll(plantDAO.getAllPlants());
        plantsTable.setItems(plantList);
    }

    @FXML
    private void openAddPlantDialog() {
        System.out.println("Open Add Plant Dialog");
    }
}