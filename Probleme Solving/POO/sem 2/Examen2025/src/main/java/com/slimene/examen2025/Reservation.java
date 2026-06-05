package com.slimene.examen2025;

import java.sql.Date;

public class Reservation {
    private int id;
    private String adresse_depart;
    private String adresse_destination;
    private Date date_reservation;
    private String status;
    private String telephone;
    private String nom;

    public Reservation(int id, String adresse_depart, String adresse_destination, Date date_reservation, String status,String nom) {
        this.id = id;
        this.adresse_depart = adresse_depart;
        this.adresse_destination = adresse_destination;
        this.date_reservation = date_reservation;
        this.status = status;
        this.nom=nom;
    }

    public Reservation(int id, String adresse_depart, String adresse_destination, Date date_reservation, String status, String telephone,String nom) {
        this.id = id;
        this.adresse_depart = adresse_depart;
        this.adresse_destination = adresse_destination;
        this.date_reservation = date_reservation;
        this.status = status;
        this.telephone = telephone;
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse_depart() {
        return adresse_depart;
    }

    public void setAdresse_depart(String adresse_depart) {
        this.adresse_depart = adresse_depart;
    }

    public String getAdresse_destination() {
        return adresse_destination;
    }

    public void setAdresse_destination(String adresse_destination) {
        this.adresse_destination = adresse_destination;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", adresse_depart='" + adresse_depart + '\'' +
                ", adresse_destination='" + adresse_destination + '\'' +
                ", date_reservation=" + date_reservation +
                ", status='" + status + '\'' +
                ", telephone='" + telephone + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
