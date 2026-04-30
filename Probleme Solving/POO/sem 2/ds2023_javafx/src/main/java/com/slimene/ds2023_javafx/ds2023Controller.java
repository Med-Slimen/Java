package com.slimene.ds2023_javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class ds2023Controller implements Initializable {
    @FXML
    private TextField nomC;
    @FXML
    private TextField expC;
    @FXML
    private TextField langC;
    @FXML
    private TextField scoreC;
    @FXML
    private TextField idOff;
    @FXML
    private ComboBox<Integer> idOffCombo;
    @FXML
    private ComboBox<Candidat> candCombo;
    @FXML
    private Button enrgBtn;
    @FXML
    private Button ajoutComptBtn;
    private Candidat candidatEnCours = null;
    private Set<Candidat> sc=new HashSet<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void enregistrerCandidat(){
        String nom=nomC.getText();
        String exp=expC.getText();
        if(nom.isEmpty() || exp.isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Verification error");
            a.setContentText("Les Chaps ne doit etre pas vide");
            a.show();
            return;
        }
        Candidat c=new Candidat(nom,Integer.parseInt(exp));
        sc.add(c);
        this.candCombo.getItems().addAll(sc);
    }
    @FXML
    public void ajouterComp(){
        this.candidatEnCours=this.candCombo.getValue();
        if(this.candidatEnCours==null){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Verification error");
            a.setContentText("Selectionner un candidat !");
            a.show();
            return;
        }
        String lang=this.langC.getText();
        String score=this.scoreC.getText();
        if(lang.isEmpty() || score.isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Verification error");
            a.setContentText("Les Chaps ne doit etre pas vide");
            a.show();
            return;
        }
        this.candidatEnCours.ajoutComp(lang,Integer.parseInt(score));
        this.candCombo.getItems().clear();
        this.candCombo.getItems().addAll(sc);
    }
}
