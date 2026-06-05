package com.slimene.examen_2024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SingletonConnexion {
    static String protocole = "jdbc:mysql:" ;
    // Adresse IP de l’hôte de la base
    static String ip = "localhost" ;
    // port MySQL par défaut
    static String port = "3306" ;
    // Nom de la base ;
    static String nomBase = "quiz" ;
    // Chaîne de connexion
    static String conString = protocole + "//" + ip + ":" + port + "/"
            + nomBase ;
    // Identifiants de connexion et mot de passe
    static String nomConnexion = "root" ;
    static String motDePasse = "" ;
    // Connexion
    static Connection con = null;
    static {
        try {
            con=(Connection) DriverManager.getConnection(conString,

                    nomConnexion, motDePasse);
        } catch (SQLException e) {

// TODO Auto-generated catch block
            e.printStackTrace();
        } }
    public static Connection getcn()
    {
        return con;
    }

}
