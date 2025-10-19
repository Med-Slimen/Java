public class Employe_commerciaux extends Employe {
    private double sommeFix;
    private int chiffreAffaire;
    public Employe_commerciaux(String nom){
        super(nom);
    }
    public Employe_commerciaux(String nom,int chiffreAffaire,double sommeFix){
        super(nom);
        this.chiffreAffaire=chiffreAffaire;
        this.sommeFix=sommeFix;
    }
    public void setInfoSalaire(double sommeFix,int chiffreAffaire){
        this.sommeFix=sommeFix;
        this.chiffreAffaire=chiffreAffaire;
    }
    public double getSalaireEmp(){
        return sommeFix+(chiffreAffaire*0.1);
    }
}
