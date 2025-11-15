public class Appartement extends ProrietePrivee {
    private int numEtage;
    public Appartement(int id, Person responsable, String adress, double surface, int nbPiece, int numEtage){
        super(id,responsable,adress,surface,nbPiece);
        this.numEtage=numEtage;
    }
    @Override
    public String toString() {
        return super.toString()+" | numEtage "+numEtage;
    }
}
