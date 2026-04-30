package com.slimene.tp3_3javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class StagiaireController implements Initializable {
    GestionStagiaires gs=new GestionStagiaires();
    @FXML
    private VBox vBox;
    @FXML
    private TextField idStag;
    @FXML
    private TextField nomStag;
    @FXML
    private TextField specStag;
    @FXML
    private TextArea textArea;
    @FXML
    private Label res;
    @FXML
    private Button addBtn;
    @FXML
    private Button suppBtn;
    @FXML
    private Button rechBtn;
    @FXML
    private Button affBtn;
    private int textSize=10;
    @FXML
    private MenuItem viderMenu;
    @FXML
    private MenuItem quitterrMenu;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.textArea.addEventHandler(ScrollEvent.SCROLL,e->{
            if(e.getDeltaY()>0){
                textSize++;
                this.textArea.setStyle("-fx-font-size:"+textSize+"px;");
            }
            else{
                textSize--;
                this.textArea.setStyle("-fx-font-size:"+textSize+"px;");
            }
        });
        this.idStag.addEventFilter(KeyEvent.KEY_TYPED,e->{
            if(!e.getCharacter().matches("\\d+")){
                e.consume();
            }
        });
        this.addBtn.addEventHandler(MouseEvent.MOUSE_ENTERED,e->{
            res.setText("Ajout du stagiaire");
        });
        this.addBtn.addEventHandler(MouseEvent.MOUSE_EXITED,e->{
            res.setText("");
        });
        this.vBox.addEventHandler(KeyEvent.KEY_PRESSED,e->{
            if(e.getCode()== KeyCode.ENTER){
               ajoutStag();
            }
        });
        this.textArea.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED,e->{
            e.consume();
            new Alert(Alert.AlertType.WARNING).show();
        });
        this.textArea.setText(this.gs.afficherTous());
    }
    @FXML
    public void ajoutStag(){
        if (idStag.getText().isEmpty() || nomStag.getText().isEmpty() || specStag.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Verification Error");
            a.setContentText("Les champs ne doit etre pas vide !");
            a.show();
            return;
        }
        int id=parseInt(idStag.getText());
        this.gs.ajouter(new Stagiaire(id,nomStag.getText(),specStag.getText()));
        this.idStag.clear();
        this.nomStag.clear();
        this.specStag.clear();
        this.textArea.setText(this.gs.afficherTous());
    }
    @FXML
    public void afficher(){
        this.textArea.setText(this.gs.afficherTous());
    }
    @FXML
    public void viderAffiche(ActionEvent event){
        this.textArea.clear();
    }
    @FXML
    public void quitterMenu(){
        Platform.exit();
    }
    @FXML
    public void supprimer(){
        String id=this.idStag.getText();
        if(id.isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Verification Error");
            a.setContentText("Les champs ne doit etre pas vide !");
            a.show();
            return;
        }
        if(!this.gs.existe(Integer.parseInt(id))) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Verification Error");
            a.setContentText("ID introuvable !");
            a.show();
            return;
        }
        this.gs.supprimer(new Stagiaire(Integer.parseInt(id),null,null));

    }
}
