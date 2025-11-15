public class AssietteCarree extends Assiette {
    private double cote;
    public AssietteCarree(int annee,double cote) {
        super(annee);
        this.cote = cote;
    }
    public double calculeSurface() {
        return cote*cote;
    }
    public int  calculeValeur() {
        return super.calculeValeur()*5;
    }
}
