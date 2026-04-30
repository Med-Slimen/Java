package com.slimene.tp2jdbc_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class EtudiantController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private RadioButton female;
    @FXML
    private ComboBox<String> filiere;
    ObservableList<Etudiant> es = FXCollections.observableArrayList();
    @FXML private TableView<Etudiant> table;
    @FXML private TableColumn<Etudiant, Integer> id;
    @FXML private TableColumn<Etudiant, Integer> nomT;
    @FXML private TableColumn<Etudiant, Integer> prenomT;
    @FXML private TableColumn<Etudiant, Integer> sexeT;
    @FXML private TableColumn<Etudiant, Integer> filiereT;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EtudiantM em=new EtudiantM();
        filiere.getItems().addAll("DSI", "RSI", "SEM");
        filiere.setValue("DSI");
        es.addAll(em.findAll());
        table.setItems(es);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomT.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomT.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        sexeT.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        filiereT.setCellValueFactory(new PropertyValueFactory<>("filiere"));
    }
    public void ajoutEtudiant(ActionEvent event) {
        EtudiantM em=new EtudiantM();
        boolean f=this.female.isSelected();
        String genre="Male";
        if (f) {
            genre="Female";
        }
        Etudiant e=new Etudiant(this.nom.getText(),this.prenom.getText(),genre,this.filiere.getValue());
        em.create(e);
        es.add(e);
        this.table.setItems(es);

    }
    public void supprimerEtudiant(ActionEvent event) {
        EtudiantM em=new EtudiantM();
        Etudiant e=this.table.getSelectionModel().getSelectedItem();
        em.delete(e);
        es.remove(e);
        this.table.setItems(es);
    }
    public void modifierEtudiant(ActionEvent event) {
        boolean f=this.female.isSelected();
        String genre="Male";
        if (f) {
            genre="Female";
        }
        EtudiantM em=new EtudiantM();
        Etudiant eOld=this.table.getSelectionModel().getSelectedItem();
        Etudiant eNew=new Etudiant(eOld.getId(),this.nom.getText(),this.prenom.getText(),genre,this.filiere.getValue());
        em.update(eNew);
        es.remove(eOld);
        es.add(eNew);
        this.table.setItems(es);
    }
}
