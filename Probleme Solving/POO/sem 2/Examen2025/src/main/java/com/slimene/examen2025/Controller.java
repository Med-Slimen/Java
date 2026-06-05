package com.slimene.examen2025;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.jshell.spi.ExecutionControlProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

public class Controller  {
    @FXML
    private ComboBox<String> statusFilterComboBox;
    @FXML
    private ComboBox<String> destinationFilterComboBox;
    @FXML
    private TableView<Reservation> reservationTable;
    @FXML
    private TableColumn<Reservation, String> idColumn;
    @FXML
    private TableColumn<Reservation, String> nomColumn;
    @FXML
    private TableColumn<Reservation, String> telephoneColumn;
    @FXML
    private TableColumn<Reservation, String> departColumn;
    @FXML
    private TableColumn<Reservation, String> destinationColumn;
    @FXML
    private TableColumn<Reservation, String> dateColumn;
    @FXML
    private TableColumn<Reservation, String> statusColumn;
    @FXML
    private TextArea resultArea;
    private ObservableList<Reservation> reservationData =
            FXCollections.observableArrayList();
    private ObservableList<String> destinationList =
            FXCollections.observableArrayList();
    public void initialize(){
        statusFilterComboBox.getItems().addAll("Tous","PENDING","VALIDATED","REFUSED");
        statusFilterComboBox.setValue("Tous");
        loadDestinations();
        destinationFilterComboBox.setItems(destinationList);
        destinationFilterComboBox.setValue(destinationList.get(0));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<>
                ("telephone"));
        departColumn.setCellValueFactory(new PropertyValueFactory<>
                ("adresse_depart"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("adresse_destination"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<> ("date_reservation"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        // Load all reservations initially
        statusFilterComboBox.setOnAction((e)->{
            String status=statusFilterComboBox.getValue();
            String dest=destinationFilterComboBox.getValue();
            loadReservations(status,dest);
        });
        destinationFilterComboBox.setOnAction((e)->{
            String status=statusFilterComboBox.getValue();
            String dest=destinationFilterComboBox.getValue();
            loadReservations(status,dest);
        });
        loadReservations("Tous", "Tous");
        reservationTable.setItems(reservationData);
    }
    public void loadDestinations(){
        destinationList.add("Tous");
        String query="SELECT Distinct(adresse_destination) as dest from reservation";
        try(Connection conn= DatabaseConnection.getConnection();
            Statement st=conn.createStatement())
        {
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                destinationList.add(rs.getString("dest"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void loadReservations(String status,String dest){
        reservationData.clear();
        String query = "";
        int index=1;
        if(status.equals("Tous") && dest.equals("Tous"))
        {
            query="SELECT * from reservation";
        }
        else if (!status.equals("Tous") && dest.equals("Tous")) {
            query="SELECT * from reservation where status=?";
        }
        else if (status.equals("Tous") && !dest.equals("Tous")){
            query="SELECT * from reservation where adresse_destination=?";
        }
        else {
            query="SELECT * from reservation where status=? and adresse_destination=?";
        }
        try(Connection conn=DatabaseConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(query))
        {
            if(!status.equals("Tous")){
                ps.setString(index,status);
                index++;
            }
            if(!dest.equals("Tous")){
                ps.setString(index,dest);
            }
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                reservationData.add(
                        new Reservation(
                                rs.getInt("id"),
                                rs.getString("adresse_depart"),
                                rs.getString("adresse_destination"),
                                rs.getDate("date_reservation"),
                                rs.getString("status"),
                                rs.getString("client_id"),
                                rs.getString("nom")
                        ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
