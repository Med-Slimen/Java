public class Jeu {
    private Carte[] tabCartes;
    private int nb=0;
    private int maxCarte;
    public Jeu(int maxCarte) {
        this.maxCarte=maxCarte;
        this.tabCartes = new Carte[maxCarte];
    }
    public void ajouter(Carte c){
        if (this.nb>10){
            System.out.println("Erreur Ajout de la cout !");
        }
        else{
            this.tabCartes[this.nb]=c;
            this.nb++;
        }
    }
    public void jouer(){
        int i=0;
        while(tabCartes[i]==null){
            i++;
        }
        System.out.println("La Carte joué est : "+tabCartes[i]);
        tabCartes[i]=null;
    }
    public void afficher(){
        for(int i=0;i<nb;i++){
            if (tabCartes[i]!=null){
                System.out.println(tabCartes[i]);
            }
        }
    }
}
