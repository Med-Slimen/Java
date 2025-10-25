import java.util.Scanner;

public class Film {
    protected String titre;
    protected String realisateur;
    protected String pays;
    protected int duree;
    protected int nbrPlacesRes;
    public Film(String titre, String realisateur, String pays, int duree,int nbrPlacesRes) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.pays = pays;
        this.duree = duree;
        this.nbrPlacesRes = nbrPlacesRes;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getRealisateur() {
        return realisateur;
    }
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }
    public int getDuree() {
        return duree;
    }
    public void setDuree(int duree) {
        this.duree = duree;
    }
    public int getNbPlacesRes() {
        return nbrPlacesRes;
    }
    public void setNbPlacesRes(int nbrPlacesRes) {
        this.nbrPlacesRes = nbrPlacesRes;
    }
    @Override
    public String toString() {
        return titre+" de "+realisateur+" ( "+pays+" ) - "+duree+"min.";
    }
    public float totalVenteBillets(){
        Scanner s=new  Scanner(System.in);
        System.out.println("Donner le nombre d etudiant reservé pour le film "+titre+" : ");
        int nbrEtudiant= s.nextInt();
        if (nbrEtudiant<nbrPlacesRes){
            int nbrPublic=nbrPlacesRes-nbrEtudiant;
            float prixEtu=nbrEtudiant*2;
            float prixPublic=nbrPublic*3;
            return prixEtu+prixPublic;
        }
        else{
            System.out.println("⚠️ Erreur : le nombre d’étudiants dépasse les places réservées !");
            return 0;
        }
    }

}
