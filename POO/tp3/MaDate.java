import java.util.Scanner;
public class MaDate {
private int jours ;
private int Mois ;
private int Annee ;

    @Override
    public String toString() {
        return jours+"/"+Mois+"/"+Annee;
    }
    public int getJour(){
        return this.jours;
    }
    public int getMois(){
        return this.Mois;
    }
    public int getAnnee(){
        return this.Annee;
    }
    public void setJour(int jours){
        this.jours=jours;
    }
    public void setMois(int Mois){
        this.Mois=Mois;
    }
    public void setAnnee(int Annee){
        this.Annee=Annee;
    }
    public MaDate(int jours,int Mois,int Annee){
        this.jours=jours;
        this.Mois=Mois;
        this.Annee=Annee;
    }
    public MaDate(int Annee){
        this.jours=1;
        this.Mois=1;
        this.Annee=Annee;
    }
    public int nbJours(){
        switch (this.Mois) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            default:
            return 30;
        }
}
    public void ajouterUnJour(){
        this.jours+=1;
        if (this.jours>nbJours()) {
            this.jours=1;
            this.Mois+=1;
            if (this.Mois==13) {
                this.Mois=1;
                this.Annee+=1;
            }
        }
    }
    public void ajouterPluseursJours(int n){
        for (int i = 0; i < n; i++) {
            ajouterUnJour();
        }
    }
    public void ajouterUnMois(){
        this.Mois+=1;
        if (this.Mois==13) {
            this.Mois=1;
            this.Annee+=1;
        }
    }
    public void ajouterUnAn(){
        this.Annee+=1;
    }
    public static void main(String []args){
        MaDate d1=new MaDate(10,12,2024);
        MaDate d2=new MaDate(31,05,2025);
        MaDate d3=new MaDate(2024);
        System.out.println("Avant modification :"+d1+" | "+d2+" | "+d3);
        d1.setJour(12);
        d2.setAnnee(2015);
        d3.setJour(2);
        System.out.println("Aprés modification :"+d1+" | "+d2+" | "+d3);
        boolean test=true;
        while(test){
            System.out.println("Choissiez une option : ");
            System.err.println("1/ Ajout d’un jour \n 2/ Ou ajout de plusieurs jours \n 3/ Ajout d’un mois \n 4/ Ajout d’une année \n 5 Quitter ");
            Scanner s=new Scanner(System.in);
            int c=s.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Avant modification :"+d1);
                    d1.ajouterUnJour();
                    System.out.println("aprés modification :"+d1);
                    break;
                case 2:
                    System.out.println("Avant modification :"+d1);  
                    d1.ajouterPluseursJours(5);
                    System.out.println("aprés modification :"+d1);
                    break;
                case 3:
                    System.out.println("Avant modification :"+d1);
                    d1.ajouterUnMois();
                    System.out.println("aprés modification :"+d1);
                    break;
                case 4:
                    System.out.println("Avant modification :"+d1);
                    d1.ajouterUnAn();
                    System.out.println("aprés modification :"+d1);
                    break;
                default:
                    test=false;
                    break;
            }
        }
        
    }
}
