public class Athlete {
    private int id;
    private String nom;
    private String pays;
    private Resultat resultat;
    public Athlete(int id, String nom, String pays) {
        super();
        this.id = id;
        this.nom = nom;
        this.pays = pays;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }
    public Resultat getResultat() {
        return resultat;
    }
    public void setResultat(Resultat resultat){
        this.resultat=resultat;
    }
}
