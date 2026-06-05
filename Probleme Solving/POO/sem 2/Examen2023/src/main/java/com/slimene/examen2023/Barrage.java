package com.slimene.examen2023;

import java.util.ArrayList;

public class Barrage {
    private int idB;
    private String nom;
    private int qtEau;
    ArrayList<Gouvernorat> listGouv;
    public Barrage(int idB, String nom, int qtEau, ArrayList<Gouvernorat> listGouv) {
        this.idB = idB;
        this.nom = nom;
        this.qtEau = qtEau;
        this.listGouv = listGouv;}
    public int getIdB() {
        return idB;}
    public String getNom() {
        return nom;}
    public int getQtEau() {
        return qtEau;}
    public ArrayList<Gouvernorat> getListGouv() {
        return listGouv;}
}
