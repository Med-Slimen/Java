package com.slimene.examen_2024;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class IntEtudController implements Initializable{
    @FXML
    private Label NumQ;
    @FXML
    private Label Enonce;
    @FXML
    private Button Rep1;
    @FXML
    private Button Rep2;
    @FXML
    private Button Rep3;
    @FXML
    private TextField matricule;
    private List<Question> listQ;
    private int indiceQuestion; // indice de la question en cours
    private int note = 0; // le total des points cumulés par l'étudiant
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        listQ = new ArrayList<Question>();
        this.Rep1.setDisable(true);
        this.Rep2.setDisable(true);
        this.Rep3.setDisable(true);
        indiceQuestion = 0;
        NumQ.setText("Question N" + String.valueOf(indiceQuestion+1));
        String query="SELECT * from question";
        try(Statement st=SingletonConnexion.getcn().createStatement()){
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                listQ.add(new Question(
                        rs.getInt("idQ"),
                        rs.getString("Enonce"),
                        rs.getString("Rep1"),
                        rs.getString("Rep2"),
                        rs.getString("Rep3"),
                        rs.getInt("RepJuste")
                ));
            }
            Question q1=this.listQ.get(indiceQuestion);
            this.Enonce.setText(q1.getEnonce());
            this.Rep1.setText(q1.getRep1());
            this.Rep2.setText(q1.getRep2());
            this.Rep3.setText(q1.getRep3());
        }
        catch(Exception e){
            e.printStackTrace();
        }
// A Compléter

    }
    @FXML
    void VerifMatricule(ActionEvent event)
    {
    String query="SELECT Matricule From etudiant where Matricule = ?";
    try(PreparedStatement ps=SingletonConnexion.getcn().prepareStatement(query)){
        ps.setString(1,this.matricule.getText());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            this.matricule.setDisable(true);
            this.Rep1.setDisable(false);
            this.Rep2.setDisable(false);
            this.Rep3.setDisable(false);
        }
        else{
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Error !");
            a.setContentText("Matricule Not found");
            a.show();
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
// A Compléter

    }
    @FXML
    void TraiterQuestion (ActionEvent event)
    {
        String repJuste="Rep"+this.listQ.get(indiceQuestion).getRepJuste();
    if(((Button)event.getSource()).getId().equals(repJuste)){
        note++;}
        String query="Insert into reponse values(?,?,?)";
        try(PreparedStatement ps=SingletonConnexion.getcn().prepareStatement(query)){
            ps.setString(1,this.matricule.getText());
            ps.setInt(2,this.listQ.get(indiceQuestion).getIdQ());
            ps.setInt(3,this.listQ.get(indiceQuestion).getRepJuste());
            ps.executeUpdate();
            if(indiceQuestion==this.listQ.size()-1){
                String q="Update Etudiant set note=? where matricule=?";
                PreparedStatement p=SingletonConnexion.getcn().prepareStatement(q);
                p.setInt(1,this.note);
                p.setString(2,this.matricule.getText());
                p.executeUpdate();
                p.close();
                this.Rep1.setDisable(true);
                this.Rep2.setDisable(true);
                this.Rep3.setDisable(true);
                Alert a=new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Quiz Terminé !");
                a.setContentText("Tu as finit la quiz , votre note est : "+this.note);
                a.show();
            }
            else{
                indiceQuestion++;
                Question q1=this.listQ.get(indiceQuestion);
                NumQ.setText("Question N" + String.valueOf(indiceQuestion+1));
                this.Enonce.setText(this.listQ.get(indiceQuestion).getEnonce());
                this.Rep1.setText(this.listQ.get(indiceQuestion).getRep1());
                this.Rep2.setText(this.listQ.get(indiceQuestion).getRep2());
                this.Rep3.setText(this.listQ.get(indiceQuestion).getRep3());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

// A Compléter

    }
}
