public class Employe_ordinaire extends Employe {
    public Employe_ordinaire(String nom){
        super(nom);
    }
    public Employe_ordinaire(int heure,int tarifHorraire,String nom){
        super(heure, tarifHorraire, nom);
    }
    public void setInfoSalaire(int heurTravaille,int tarifHorraire){
        super.heurTravaille=heurTravaille;
        super.tarifHorraire=tarifHorraire;
    }
    public double getSalaireEmp(){
        if (heurTravaille<39){
            return heurTravaille*tarifHorraire;
        }
        else{
            int heurSup=heurTravaille-39;
            return 39*tarifHorraire+(heurSup*(tarifHorraire*1.3));
        }
    }
}
