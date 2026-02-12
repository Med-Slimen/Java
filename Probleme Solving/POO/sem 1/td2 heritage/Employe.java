public class Employe {
    protected String nom;
    protected int heurTravaille;
    protected int tarifHorraire;
    public Employe(String nom){
        this.nom=nom;
    }
    public Employe(int heure,int tarifHorraire,String nom){
        this.nom=nom;
        this.heurTravaille=heure;
        this.tarifHorraire=tarifHorraire;
    }
    public String getNom(){
        return  this.nom;
    }
    public void setInfoSalaire(int heurTravaille,int tarifHorraire){
    }
    public double getSalaireEmp(){
        return 0;
    }


}
