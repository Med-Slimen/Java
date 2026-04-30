package com.slimene.tp3_3javafx;

import javafx.scene.control.Alert;

import java.util.HashSet;
import java.util.Set;
public class GestionStagiaires {
    private Set<Stagiaire> stagiaires;
    public GestionStagiaires() {
        this.stagiaires=new HashSet<>();
    }
    // ajouter un stagiaire (id > 0 uniquement)
    public void ajouter(Stagiaire s) {
        if(s.getId()<=0){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Verification error");
            a.setContentText("L'Id de stagiaire doit etre > 0");
            a.show();
            return;
        }
        this.stagiaires.add(s);
    }
    // supprimer un stagiaire
    public void supprimer(Stagiaire s) {
        this.stagiaires.remove(s);
    }
    // rechercher un stagiaire par id
    public Stagiaire rechercher(int id) {
        for(Stagiaire s:this.stagiaires){
            if(s.getId()==id)return s;
        }
        return null;
    }
    // vérifier existence d’un stagiaire
    public boolean existe(int id) {
        for(Stagiaire s:this.stagiaires){
            if(s.getId()==id)return true;
        }
        return false;
    }
    // afficher tous les stagiaires
    public String afficherTous() {
        String msg="-- Les Liste de tous les stagiaires ---\n";
        for(Stagiaire s:this.stagiaires){
            msg+=s+"\n";
        }
        msg+="--------------------------------------";
        return msg;
    }
}
