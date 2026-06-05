package com.slimene.examen2023;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

import static java.lang.Integer.parseInt;

public class ControleurPluviometrie implements Initializable{
        @FXML
        private ComboBox<String> nomb;
        @FXML
        private TextField QtEauB;
        @FXML
        private TableColumn<Gouvernorat, String>nomG;
        @FXML
        private TableColumn<Gouvernorat, Float>DistMer;
        @FXML
        private TableColumn<Gouvernorat, Integer>QtEauCons;
        @FXML
        private TableView<Gouvernorat>tableG;
        @FXML
        private Button btsupp;
        @FXML
        private Button bt_miseajour;
        @FXML
        private Button btmanque;
        ObservableList<Gouvernorat> listG = FXCollections.observableArrayList();
        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
//Remplissage de comboBox par les noms des Barrages

            ArrayList<String> list=new ArrayList();
//Récupérer les noms des barrages de la base et l'ajouter à la listB
            String query="SELECT * FROM Barrage";
            try (Statement st=Connexion.con.createStatement()) {
                //*****Code à completer ****//
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){
                    list.add(rs.getString("nom"));
                }
            }
            catch (SQLException e) { e.printStackTrace(); }
// La liste construite doit être ajouté au ComboBox
                ObservableList<String> listB = FXCollections.observableArrayList(list);
                nomb.setItems(listB);
//Mapping
                nomG.setCellValueFactory(new PropertyValueFactory<Gouvernorat,String>("nom"));
                DistMer.setCellValueFactory(new PropertyValueFactory<Gouvernorat,Float>("distMer"));
                QtEauCons.setCellValueFactory(new PropertyValueFactory<Gouvernorat,Integer>("qtEauCons"));
                tableG.setItems(listG);
            }
        public void detailBarrage (ActionEvent event){
            listG.clear();
            String b=nomb.getValue();
            String query="SELECT * from barrage where nom=?";
            try(PreparedStatement ps=Connexion.con.prepareStatement(query)){
                ps.setString(1,b);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    QtEauB.setText(rs.getString("qtEau"));
                    String query2="SELECT * from gouvernorat where idb=?";
                    try(PreparedStatement ps2=Connexion.con.prepareStatement(query2)){
                        ps2.setInt(1,rs.getInt("idB"));
                        ResultSet gvs=ps2.executeQuery();
                        while(gvs.next()){
                            listG.add(new Gouvernorat(
                                    gvs.getString("nom"),
                                    gvs.getFloat("distMer"),
                                    gvs.getInt("qtEauCons")
                            ));
                        }
                        tableG.setItems(listG);
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("No barrage trouvé");
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    public void supprimer(ActionEvent event){
            try{
                Gouvernorat g=tableG.getItems().get(tableG.getSelectionModel().getSelectedIndex());
                Alert a=new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Suppriomation du gouvernorat");
                a.setContentText("Vous voulez supprimer "+g.getNom()+" gouvernorat ?");
                Optional<ButtonType> b=a.showAndWait();
                if(b.get()==ButtonType.OK){
                    System.out.println("Supprimation....");
                    String query="DELETE FROM gouvernorat where nom=?";
                    try(PreparedStatement ps=Connexion.con.prepareStatement(query)){
                        ps.setString(1,g.getNom());
                        ps.executeUpdate();
                        tableG.getItems().remove(g);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Annulation");
                }
            }
            catch (IndexOutOfBoundsException e){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setTitle("Suppriomation du gouvernorat");
                a.setContentText("Selectionnert un gouvernorat !");
                a.show();
            }




    }
    public void manquedEau(ActionEvent event){
            String query="SELECT * from barrage where qtEau=( Select min(qtEau) from barrage )";
            String query2="SELECT * from gouvernorat where idb=?";
            try(Statement st=Connexion.con.createStatement();
            PreparedStatement ps=Connexion.con.prepareStatement(query2)
            ){
                ResultSet rs=st.executeQuery(query);
                rs.next();
                ps.setInt(1,rs.getInt("idB"));
                ResultSet gvs=ps.executeQuery();
                File f=new File("./manque.txt");
                FileWriter fw=new FileWriter(f);
                fw.write("Barrage : "+rs.getString("nom")+"\n");
                fw.write("List des gouvernoat : \n");
                while(gvs.next()){
                    fw.write("Nom : "+gvs.getString("nom") + " | Quantité d eau : "+gvs.getInt("qtEauCons")+"\n");
                }
                fw.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }
    public void MiseaJour(ActionEvent event){
            int sum=0;
            for(Gouvernorat g: listG){
                sum+=g.getQtEauCons();
            }
            String qt="SELECT * from barrage where nom=?";
            String query="Update Barrage Set qtEau=qtEau-? where nom=?";
            String query2="Update gouvernorat Set qtEauCons=0 where idB=?";
            try(PreparedStatement ps=Connexion.con.prepareStatement(query);
            PreparedStatement psQ=Connexion.con.prepareStatement(qt);
            PreparedStatement gv=Connexion.con.prepareStatement(query2)
            ){
                psQ.setString(1,nomb.getValue());
                ResultSet bar=psQ.executeQuery();
                bar.next();
                ps.setInt(1,sum);
                ps.setString(2,nomb.getValue());
                ps.executeUpdate();
                gv.setInt(1,bar.getInt("idB"));
                gv.executeUpdate();
                this.QtEauB.setText(Integer.toString(parseInt(this.QtEauB.getText())-sum));
                for(int i=0;i<listG.size();i++){
                    listG.get(i).setQtEauCons(0);
                }
                tableG.refresh();
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }
}
