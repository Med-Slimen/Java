public class Abonne extends Client {
    private double credit;
    public Abonne (long n, String marque, double credit){
        super(n,marque);
        if(credit>100){
            this.credit = credit;
        }
        else{
            System.out.println("Erreur");
        }
    }
    @Override
    public String toString(){
        return "Abonne { le nom : "+id+" | Marque : "+marque+" | Heure Arrivee : "+heurArriv+" | Heure Sortie : "+heurSortie+" | Credit : "+credit+" }";
    }
    public void rechargerAbonnement(double forfait){
        this.credit += forfait;
    }
    public void arriver(int heureArrivee){
        if (credit>heureArrivee*1.5){
            super.heurArriv=heureArrivee;
        }
        else{
            System.out.println("Erreur");
        }
    }
    public double sortir(int heureSortie){
        return credit - super.heurSortie*1.5;
    }
}
