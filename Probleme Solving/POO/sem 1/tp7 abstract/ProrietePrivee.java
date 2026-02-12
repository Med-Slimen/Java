public class ProrietePrivee extends Proriete{
    protected int nbPiece;
    public ProrietePrivee(int id, Person responsable, String adress, double surface, int nbPiece){
        super(id,responsable,adress,surface);
        this.nbPiece=nbPiece;
    }
    public int getNbPiece(){
        return nbPiece;
    }
    public double calcullmport(){
        double p=(50/100)+(10/nbPiece);
        return p;
    }
    @Override
    public String toString(){
        return super.toString()+" | nbPiece="+nbPiece;
    }
}
