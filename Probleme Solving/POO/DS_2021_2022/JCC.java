public class JCC {
    private Film[] competition;
    private String annee;
    final int NBFMAX=30;
    private int nbf;
    public JCC(String annee) {
        this.annee=annee;
        this.nbf=0;
        this.competition=new Film[NBFMAX];
    }
    public void ajouterFilm(Film f) {
        if (this.nbf<NBFMAX) {
            this.competition[this.nbf]=f;
            this.nbf++;
        }
        else{
            System.out.println("La compétition est au complet");
        }
    }
    public void listeFilms() {
        for (int i=0;i<nbf;i++) {
            System.out.println(this.competition[i]);
        }
    }
    public float totalVenteBillets() {
        float s=0;
        for (int i=0;i<nbf;i++) {
            s+=competition[i].totalVenteBillets();
        }
        return s;
    }
    public static void main(String[] args) {
        JCC j=new JCC("2021");
        j.ajouterFilm(new Documentaire("La guerre Civil","Le dernier refuge","Ousman","Mali",86,30));
        j.ajouterFilm(new Film("Insurrection","Jilani Saadi","Tunisie",105,45));
        j.listeFilms();
        for (int i=0;i<j.nbf;i++) {
            String msg="Les ventes total du billets du ";
            if (j.competition[i] instanceof Documentaire) {
                msg+="Documentaire ";
            }
            else{
                msg+="Film ";
            }
            System.out.println(msg+j.competition[i].getTitre()+" : "+ j.competition[i].totalVenteBillets());
        }

    }
}
