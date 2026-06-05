package com.slimene.examen_2024;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;

public class Question implements Comparable<Question> {
    private Integer IdQ;
    private String Enonce;
    private String Rep1;
    private String Rep2;
    private String Rep3;
    private Integer RepJuste;
    public ArrayList<Etudiant> reponse=new ArrayList<>();
    public Question(Integer idQ, String enonce, String rep1, String rep2,
                    String rep3, Integer repJuste) {

        super();
        IdQ = idQ;
        Enonce = enonce;
        Rep1 = rep1;
        Rep2 = rep2;
        Rep3 = rep3;
        RepJuste = repJuste;
    }
    public Integer getIdQ() {
        return IdQ;
    }
    public String getEnonce() {
        return Enonce;
    }
    public String getRep1() {
        return Rep1;
    }
    public String getRep2() {
        return Rep2;
    }
    public String getRep3() {
        return Rep3;
    }
    public Integer getRepJuste() {
        return RepJuste;

    }
    @Override
    public String toString() {
        return "Question [IdQ=" + IdQ + ", Enonce=" + Enonce + ", Rep1=" + Rep1 + ", Rep2=" + Rep2 + ", Rep3=" + Rep3
                + ", RepJuste=" + RepJuste + "]";

    }

    @Override
    public int compareTo(@NotNull Question o) {
        return this.reponse.size()-o.reponse.size();
    }
}
