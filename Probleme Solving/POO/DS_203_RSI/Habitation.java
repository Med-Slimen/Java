public class Habitation {
    protected int code;
    protected String nom;
    protected String surface;
    private double prix;
    protected boolean etat=false;
    public Habitation(int code){
        this.code=code;
    }
    public Habitation(int code, String nom, String surface) {
        this(code);
        this.nom=nom;
        this.surface=surface;
    }
    public double getPrix() {
        return prix;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getCode(){
        return code;
    }
    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    public boolean getEtat(){
        return etat;
    }
    @Override
    public String toString() {
        return "Habitation{" + "code=" + code+ ", nom=" + nom + ", surface=" + surface + ", prix=" + prix + '}';
    }
    public void decrire(){
        System.out.println(toString());
    }
}
