package com.slimene.examen_2024;

import java.util.ArrayList;
public class Etudiant {
    private String Matricule;
    private String Nom;
    private String Prenom;
    private Integer Note;
    private ArrayList<Question> Reponse;
    @Override
    public String toString() {
        return "Etudiant [Matricule=" + Matricule + ", Nom=" + Nom +

                ", Prenom=" + Prenom + ", Note=" + Note + "]";
    }
    public Etudiant(String matricule) {
        super();
        Matricule = matricule;
    }
    public Etudiant(String matricule, String nom, String prenom,
                    Integer note) {
        super();
        Matricule = matricule;
        Nom = nom;
        Prenom = prenom;
        Note = note;
    }
    public String getMatricule() {
        return Matricule;
    }
    public String getNom() {
        return Nom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public Integer getNote() {
        return Note;
    }
}
