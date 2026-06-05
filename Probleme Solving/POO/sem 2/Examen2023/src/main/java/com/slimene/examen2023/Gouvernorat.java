package com.slimene.examen2023;

public class Gouvernorat {
        private int idG;
        private String nom;
        private float distMer;
        private int qtEauCons;
        public Gouvernorat( String nom, float distMer, int qtEauCons) {
            this.nom = nom;
            this.distMer = distMer;
            this. qtEauCons = qtEauCons;}
        public int getIdG() {
            return idG;}
        public String getNom() {
            return nom;}
        public float getDistMer() {
            return distMer;}
        public int getQtEauCons() {
            return qtEauCons;}
        public void setQtEauCons( int qt) {

            qtEauCons=qt ;}

    }

