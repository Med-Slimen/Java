package com.slimene.tp3javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddBookController implements Initializable {
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField mail;
    @FXML
    private Button addBtn;
    @FXML
    private Button exportBtn;
    @FXML
    private Button importBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button quitBtn;
    @FXML
    private TableView<Personne> tab;
    @FXML
    private TableColumn<Personne, String> mailTab;
    @FXML
    private TableColumn<Personne, String> nomTab;
    @FXML
    private TableColumn<Personne, String> prenomTab;
    private DataClass data;
    Alert a = new Alert(Alert.AlertType.NONE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mailTab.setCellValueFactory(new PropertyValueFactory<>("mail"));
        nomTab.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomTab.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        prenomTab.setCellFactory(TextFieldTableCell.forTableColumn());
        nomTab.setCellFactory(TextFieldTableCell.forTableColumn());
        mailTab.setCellFactory(TextFieldTableCell.forTableColumn());
        prenomTab.setOnEditCommit(e ->
                e.getRowValue().setPrenom(e.getNewValue())
        );
        nomTab.setOnEditCommit(e ->
                e.getRowValue().setNom(e.getNewValue())
        );
        mailTab.setOnEditCommit(e ->
                e.getRowValue().setMail(e.getNewValue())
        );
        data = new DataClass();
        tab.setEditable(true);
    }
    @FXML
    public void importer(){
        tab.getItems().clear();
        tab.getItems().addAll(data.getImportList());
    }
    @FXML
    public void export(ActionEvent event){
        List<Personne> list = tab.getItems().stream().toList();
        data.setExportList(list);
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Exportation");
        success.setHeaderText(null);
        success.setContentText("Données exportées avec succès ! (" + list.size() + " contacts)");
        success.show();
    }
    public static boolean isEmailAdress(String email){
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$" );
        Matcher m = p.matcher(email.toUpperCase());
        return m.matches();
    }
    @FXML
    public void add(ActionEvent event){
        String prenomVal=prenom.getText();
        String nomVal=nom.getText();
        String mailVal=mail.getText();
        if(prenomVal.isEmpty() || nomVal.isEmpty()||mailVal.isEmpty() || !isEmailAdress(mailVal)){
            a.setAlertType(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Please fill all the fields");
            a.setContentText("Please fill all the fields");
            a.show();
        }
        else{
            Personne personne=new Personne(prenomVal,nomVal,mailVal);
            tab.getItems().add(personne);
            prenom.clear();
            nom.clear();
            mail.clear();
        }
    }
    @FXML
    public void quitter() {
        javafx.application.Platform.exit();
    }
    @FXML
    public void supprimer(){
        Personne selected = tab.getSelectionModel().getSelectedItem();
        tab.getItems().remove(selected);
    }
}
