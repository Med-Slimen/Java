public class HabitationPrive extends Habitation {
    private int nbrPiece;
    public HabitationPrive(int code, String nom, String surface,int nbrPieceM){
        super(code, nom, surface);
        this.nbrPiece=nbrPiece;
    }
    public HabitationPrive(int code, String nom, String surface,int nbrPieceM,int prix){
        super(code, nom, surface);
        super.setPrix(prix);
        this.nbrPiece=nbrPiece;
    }
    @Override
    public String toString() {
        return "Habitation{" + "code=" + code+ ", nom=" + nom + ", surface=" + surface + ", nombre de pieces=" + nbrPiece + '}';
    }
    public void decrire(){
        System.out.println(toString());
    }
}
