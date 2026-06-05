package com.slimene.examen_2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class mainF {
    public static void main(String[] args) {
        String pathF="./entree.txt";
        String pathS="./sortie.txt";
        int i=0;
        try(BufferedReader bf=new BufferedReader(new FileReader(pathF));
            BufferedWriter bw=new BufferedWriter(new FileWriter(pathS))
        ){
            String line;
            while((line=bf.readLine())!=null){
            i++;
            bw.write("*****Ligne"+i+"******");
            bw.newLine();
            bw.write(line);
            bw.newLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
