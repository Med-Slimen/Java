public class Sortileges extends Carte {
    private String nom;
    private String desc;
    public Sortileges(int cout, String nom, String desc) {
        super(cout);
        this.nom=nom;
        this.desc=desc;
    }
    @Override
    public String toString() {
        return "Le Sortileges => Cout : "+super.cout+" | nom : "+nom+" | Description :"+desc;
    }
}
