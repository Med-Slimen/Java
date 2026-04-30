package com.slimene.tp2jdbc_javafx;

import ma.projet.connexion.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EtudiantM {
    public boolean create (Etudiant o){
        Connection c = Connexion.getCn();
        try{
            PreparedStatement p=c.prepareStatement("insert into etudiant values (default,?,?,?,?)");
            p.setString(1, o.getNom());
            p.setString(2, o.getPrenom());
            p.setString(3, o.getSexe());
            p.setString(4, o.getFiliere());

            p.executeUpdate();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean delete (Etudiant o){
        try {
            Connection c = Connexion.getCn();
            PreparedStatement p=c.prepareStatement("delete from etudiant where id = ?");
            p.setInt(1, o.getId());
            p.executeUpdate();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean update (Etudiant o){
        try {
            Connection c = Connexion.getCn();
            PreparedStatement p=c.prepareStatement("update etudiant set nom=?, prenom=? , sexe=? , filiere=? where id = ?");
            p.setString(1, o.getNom());
            p.setString(2, o.getPrenom());
            p.setString(3, o.getSexe());
            p.setString(4, o.getFiliere());
            p.setInt(5, o.getId());
            p.executeUpdate();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public Etudiant findById (int id){
        try{

            Connection c = Connexion.getCn();
            PreparedStatement p=c.prepareStatement("select * from etudiant where id = ?");
            p.setInt(1, id);
            ResultSet rs=p.executeQuery();
            if(rs.next()){
                return new Etudiant(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("sexe"),rs.getString("filiere"));
            }
            return null;
        }
        catch(Exception e){
            return null;
        }
    }
    public ArrayList<Etudiant> findAll(){
        try{
            Connection c = Connexion.getCn();
            PreparedStatement p=c.prepareStatement("select * from etudiant ");
            ResultSet rs=p.executeQuery();
            ArrayList<Etudiant> list=new ArrayList<>();
            while(rs.next()){
                list.add(this.findById(rs.getInt("id")));
            }
            return list;
        }
        catch(Exception e){
            return null;
        }
    }
}

