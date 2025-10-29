public class Creatures extends Carte{
    private String nom;
    private int nbrPointsDegat;
    private int nbrPointVie;
    public Creatures(int cout,String nom,int nbrPointsDegat,int nbrPointVie) {
        super(cout);
        this.nom=nom;
        this.nbrPointsDegat=nbrPointsDegat;
        this.nbrPointVie=nbrPointVie;
    }
    @Override
    public String toString() {
        return "Le Creature => Cout : "+super.cout+" | nom : "+nom+" | nombre des point Degat :"+nbrPointsDegat+" | nombre des point Vie :"+nbrPointVie;
    }
}
