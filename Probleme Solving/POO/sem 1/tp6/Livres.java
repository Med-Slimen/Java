public class Livres extends Article {
    protected String nomEditeur;
    public Livres(String nomEditeur,String nomAuteur,String titre, int numId, int nbPages) {
        super(nomAuteur,titre,numId,nbPages);
        this.nomEditeur = nomEditeur;
    }
    public void edition(){
        System.out.println("Type : "+getType()+" , Titre : "+getTitre()+" numId : "+getNumId()+", nbPages : "+getNbPages()+", nomAuteur : "+getNomAuteur()+", NomEditeur : "+getNomEditeur());
    }
    public String getNomEditeur() {
        return nomEditeur;
    }
    public String getType(){
        return "Livre";
    }
}
