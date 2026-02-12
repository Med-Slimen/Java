public class ParcAttraction {
    private int taille;
    private String nom;
    private Attraction[] lesAttractions;
    private int nb_attraction=0;
    public ParcAttraction(String nom,int taille) {
        this.taille=taille;
        this.nom=nom;
        this.lesAttractions=new Attraction[taille];
    }
    public void ajouteAttraction(Attraction a){
            if (nb_attraction<taille){
                lesAttractions[nb_attraction]=a;
                nb_attraction++;
            }
            else{
                System.out.println("Taille maximale atteint !");
            }
    }
    public void getRecette(){
        double s=0;
        for(int i=0;i<nb_attraction;i++){
            s+=lesAttractions[i].getRecette();
        }
        System.out.println("Recette du parc d attraction "+nom+" : "+s);
    }
    public void affiche(){
        System.out.println("--- Parc "+nom+" ---");
        for (int i=0;i<nb_attraction;i++){
            lesAttractions[i].affiche();
        }
    }


}
