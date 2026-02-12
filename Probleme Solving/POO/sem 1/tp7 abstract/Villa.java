public class Villa extends ProrietePrivee {
    private boolean avecPiscine;
    public Villa(int id, Person responsable, String adress, double surface, int nbPiece, boolean avecPiscine){
        super(id,responsable,adress,surface,nbPiece);
        this.avecPiscine=avecPiscine;
    }
    @Override
    public String toString() {
        return super.toString()+" | Avec Piscine "+avecPiscine;
    }
    public double calcullmport(){
        double p=super.calcullmport();
        if(avecPiscine){
            p+=200;
        }
        return p;
    }
}
