package com.slimene.tp3_3javafx;

import java.util.Objects;

public class Stagiaire {
    private int id;
    private String nom;
    private String specialite;
    public Stagiaire(int id, String nom, String specialite) {
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
    }
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getSpecialite() { return specialite; }
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    @Override
    public String toString() {
        return id + " -" + nom + " (" + specialite + ")";
    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Stagiaire)){
            return false;
        }
        return this.getId()==((Stagiaire)o).getId();
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }
}
