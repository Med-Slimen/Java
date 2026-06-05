package com.slimene.examen2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Connexion{
    static String protocole = "jdbc:mysql:" ;
    static String ip = "localhost" ;
    static String port = "3306" ;
    static String nomBase = "EAU" ;
    static String conString = protocole + "//" + ip + ":" + port + "/" + nomBase ;
    static String nomConnexion = "root" ;
    static String motDePasse = "" ;
    static Connection con = null;
    static {
        try {
            con=(Connection) DriverManager.getConnection(conString, nomConnexion, motDePasse);}
        catch (SQLException e) { e.printStackTrace();}}
    public static Connection getCn(){ return con;}}