public class Documentaire extends Film {
    private String sujet;
    static int tarif=2;
    public Documentaire(String sujet,String titre, String realisateur, String pays, int duree,int nbrPlacesRes){
        super(titre,realisateur,pays,duree,nbrPlacesRes);
        this.sujet=sujet;
    }
    public String getSujet(){
        return this.sujet;
    }
    public void setSujet(String sujet){
        this.sujet=sujet;
    }
    @Override
    public String toString(){
        return "Sujet : "+this.sujet+" | "+super.toString();
    }
    @Override
    public float totalVenteBillets(){
        return super.nbrPlacesRes*tarif;
    }
}
