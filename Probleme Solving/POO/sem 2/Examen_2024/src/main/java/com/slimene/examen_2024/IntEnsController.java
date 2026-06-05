package com.slimene.examen_2024;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
public class IntEnsController implements Initializable {
    @FXML
    private TableView<Etudiant> TEtudiant;
    @FXML
    private TableColumn<Etudiant,String> matricule;
    @FXML
    private TableColumn<Etudiant,String> nom;
    @FXML
    private TableColumn<Etudiant,String> prenom;
    @FXML
    private TableColumn<Etudiant,Integer> note;
    @FXML
    private Text txtStat;
    ObservableList<Etudiant> listE =
            FXCollections.observableArrayList(); // liste des étudiants
    private List<Question> listQ; // liste des questions
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        TEtudiant.setItems(listE);
        matricule.setCellValueFactory(new PropertyValueFactory<>("Matricule"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        note.setCellValueFactory(new PropertyValueFactory<>("Note"));
        listQ = new ArrayList<Question>();
        String query="SELECT * from question";
        String q="SELECT * from etudiant";
        try(Statement st=SingletonConnexion.getcn().createStatement();
        Statement s=SingletonConnexion.getcn().createStatement()){
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                Question qq=new Question(
                        rs.getInt("idQ"),
                        rs.getString("Enonce"),
                        rs.getString("Rep1"),
                        rs.getString("Rep2"),
                        rs.getString("Rep3"),
                        rs.getInt("RepJuste"));
                String v="SELECT * from reponse where idQ=? and numRep=?";
                PreparedStatement pp=SingletonConnexion.getcn().prepareStatement(v);
                pp.setInt(1,qq.getIdQ());
                pp.setInt(2,qq.getRepJuste());
                ResultSet ss=pp.executeQuery();
                while(ss.next()){
                    qq.reponse.add(new Etudiant(
                            ss.getString("matricule")
                    ));
                }
                listQ.add(qq);
            }
            ResultSet r=s.executeQuery(q);
            while (r.next()){
                listE.add(new Etudiant(
                        r.getString("matricule"),
                        r.getString("nom"),
                        r.getString("prenom"),
                        r.getInt("note")
                ));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
// récupération de la liste des étudiants

// à compléter

// récupération de la liste des questions

// supposé fait
    }
    @FXML
    void Exporter(ActionEvent event) throws IOException {
        try(BufferedWriter b=new BufferedWriter(new FileWriter("C:\\Users\\LENOVO\\Desktop\\Prog\\Java\\Probleme Solving\\POO\\sem 2\\Examen_2024\\quiz.txt"))){
            for(Etudiant e:listE){
                b.write(e.toString());
                b.newLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
// à compléter
    }
    @FXML
    void afficherQuestionPlusDifficile(ActionEvent event) {
        Question q=Collections.min(listQ);
        System.out.println(q);
        String txt=this.txtStat.getText();
        this.txtStat.setText(txt+q.getEnonce());
    }
}