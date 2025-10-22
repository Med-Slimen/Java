public class Documents {
    protected String titre;
    protected int numId;
    protected int nbPages;
    public Documents(String titre, int numId, int nbPages) {
        this.titre = titre;
        this.numId = numId;
        this.nbPages = nbPages;
    }
    public void edition(){
        System.out.println("Type : "+getType()+" , Titre : "+getTitre()+" numId : "+getNumId()+" nbPages : "+getNbPages());
    }
    public String getType(){
        return "Documents";
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public int getNumId() {
        return numId;
    }
    public void setNumId(int numId) {
        this.numId = numId;
    }
    public int getNbPages() {
        return nbPages;
    }
    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }
}
