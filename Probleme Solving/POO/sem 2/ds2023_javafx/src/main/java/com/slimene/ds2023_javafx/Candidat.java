package com.slimene.ds2023_javafx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;
public class Candidat {
    private String nom;
    private int anneesExperience;
    private ArrayList<Competence> comp;
    public Candidat(String nom, int anneesExperience) {
        this.nom = nom;
        this.comp = new ArrayList<Competence>();
        this.anneesExperience = anneesExperience; }
    public String getNom() { return nom; }
    public int getAnneesExperience() { return anneesExperience; }
    public ArrayList<Competence> getComp() { return comp; }
    public void setComp(ArrayList<Competence>comp) { this.comp = comp; }
    public void setNom(String nom) { this.nom = nom; }
    public void setAnneesExperience(int anneesExperience) {
        this.anneesExperience = anneesExperience; }
    public void ajoutComp(String langage, int score) {
        Competence c=new Competence(langage,score);
        if(comp.contains(c)){
            System.out.println("Competence existe deja");
            return;
        }
        this.comp.add(c);
    }

        @Override
        public String toString() {
            String msg="Nom du candidat : "+this.nom+" | annees d experience : "+this.anneesExperience + " \n List des competences : ";
            TreeSet<Competence> cc=new TreeSet<>(this.comp);
            Iterator<Competence> it=cc.iterator();
            while(it.hasNext()){
                Competence cm=it.next();
                msg+=" Langauge : "+cm.getNom()+" | Score : "+cm.getScore();
            }
            return msg;
        }
        @Override
        public boolean equals(Object o){
        if(!(o instanceof Candidat))return false;
        return this.nom.equals(((Candidat)o).getNom());
        }
        @Override
        public int hashCode(){
        return Objects.hash(this.getNom());
        }
    }