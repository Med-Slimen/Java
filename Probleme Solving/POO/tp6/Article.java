public class Article extends Documents {
    protected String nomAuteur;
    public Article(String nomAuteur,String titre, int numId, int nbPages) {
        super(titre, numId, nbPages);
        this.nomAuteur = nomAuteur;
    }
    public void edition(){
        System.out.println("Type : "+getType()+" , Titre : "+getTitre()+" numId : "+getNumId()+" nbPages : "+getNbPages()+"nomAuteur : "+getNomAuteur());
    }
    public String getNomAuteur() {
        return nomAuteur;
    }
    public String getType(){
        return "Article";
    }
}
