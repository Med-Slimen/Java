package com.slimene.examen2025;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.time.LocalDateTime;

public class ClientController {
    @FXML
    private TextField clientTelephoneField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField adresseDepartField;
    @FXML
    private TextField adresseDestinationField;
    @FXML
    private TableView<Reservation> reservationTable;
    @FXML
    private TableColumn<Reservation,Integer> idColumn;
    @FXML
    private TableColumn<Reservation, String> nomColumn;
    @FXML
    private TableColumn<Reservation, String> departColumn;
    @FXML
    private TableColumn<Reservation, String> destinationColumn;
    @FXML
    private TableColumn<Reservation, String> dateColumn;
    @FXML
    private TableColumn<Reservation, String> statusColumn;
    private ObservableList<Reservation> reservationData =FXCollections.observableArrayList();
    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        departColumn.setCellValueFactory(new PropertyValueFactory<>("adresse_depart"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("adresse_destination"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        reservationTable.setItems(reservationData);
    }
    public void ajouterReservation() {
        String nom = nomField.getText();
        String adresseDepart = adresseDepartField.getText();
        String adresseDestination = adresseDestinationField.getText();
        String telephone = clientTelephoneField.getText();
        try (Connection conn = DatabaseConnection.getConnection()) {
// Insert reservation
            String sqlReservation = "INSERT INTO reservation VALUES(default,?,?,?,?,?,?)";
            PreparedStatement stmtReservation = conn.prepareStatement(sqlReservation);
//code a completer(1.2)

            stmtReservation.setString(1,telephone);
            stmtReservation.setString(2,adresseDepart);
            stmtReservation.setString(3,adresseDestination);
            stmtReservation.setTimestamp(4,java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmtReservation.setString(5,"PENDING");
            stmtReservation.setString(6,nom);
            stmtReservation.executeUpdate();
            clearFields();
            loadReservations();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void clearFields(){
        nomField.clear();
        adresseDepartField.clear();
        adresseDestinationField.clear();
    }
    public void loadReservations(){
        reservationData.clear();
        String currentClientTelephone=clientTelephoneField.getText();
        if (currentClientTelephone == null || currentClientTelephone.isEmpty()) {
            return;
        }
        try(Connection conn = DatabaseConnection.getConnection()){
            String query="SELECT * from reservation where client_id=?";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,currentClientTelephone);
            ResultSet res=ps.executeQuery();
            while(res.next()){
                reservationData.add(new Reservation(
                        res.getInt("id"),
                        res.getString("adresse_depart"),
                        res.getString("adresse_destination"),
                        res.getDate("date_reservation"),
                        res.getString("status"),
                        res.getString("nom")
                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteReservation(){
        Reservation r=reservationTable.getSelectionModel().getSelectedItem();
        String query="DELETE FROM reservation where id=?";
        try(Connection conn=DatabaseConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(query))
        {
            ps.setInt(1,r.getId());
            ps.executeUpdate();
            loadReservations();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
