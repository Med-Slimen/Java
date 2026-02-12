public class ProprieteProfessionnelle extends Proriete {
    private int nbEmploye;
    private boolean estEtatique;
    public ProprieteProfessionnelle(int id, Person responsable, String adress, double surface, int nbEmploye, boolean estEtatique) {
        super(id,responsable,adress,surface);
        this.nbEmploye = nbEmploye;
        this.estEtatique = estEtatique;
    }
    public double calcullmport(){
       if (estEtatique){
           return 100/100+30/nbEmploye;
       }
       else{
           return 0;
       }
    }
    @Override
    public String toString(){
        return super.toString()+" | nbEmploye="+nbEmploye;
    }
}
