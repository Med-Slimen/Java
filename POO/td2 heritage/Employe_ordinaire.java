public class Employe_ordinaire extends Employe {
    private int heure;
    private int tarifHorraire;
    public Employe_ordinaire(String nom){
        super(nom);
    }
    public Employe_ordinaire(int heure,int tarifHorraire,String nom){
        super(nom);
        this.heure=heure;
        this.tarifHorraire=tarifHorraire;
    }
}
