public class AgenceImmobiliere {
    private Habitation[] habit=new Habitation[100];
    private int numHabit=0;
    public  void mettreSousVente(Habitation h){
        habit[numHabit++]=h;
    }
    public void afficher(){
        System.out.println("--- Affichage du tous les habitations");
        for(int i=0;i<numHabit;i++){
            habit[i].decrire();
        }
    }
    public void afficherPrivee(){
        System.out.println("--- Affichage du habitations privé non vendu");
        for(int i=0;i<numHabit;i++){
            if(habit[i] instanceof HabitationPrive && !habit[i].getEtat()){
                ((HabitationPrive)habit[i]).decrire();
            }
        }
    }
    public int chercherHabitation(int c){
        for(int i=0;i<numHabit;i++){
            if(habit[i].getCode()==c){
                return i;
            }
        }
        System.out.println("Nous sommes désolés, l’habitation de code"+ c +"n’est pas présentée pour vente");
        return -1;
    }
    public boolean estVendue(int c){
        int i=chercherHabitation(c);
        if (i != -1) {
            return habit[i].getEtat();
        }
        return false;
    }
    public void vendre(Habitation h, double prixVente, String nomClient){
        h.setPrix(prixVente);
        h.setNom(nomClient);
        h.setEtat(true);
    }
    public static void main(String []args){
        AgenceImmobiliere a = new AgenceImmobiliere();
        Habitation h1=new Habitation(10001, " Mohamed Ben Ali", "75 m2");
        Habitation h2=new HabitationPrive(10002, " Mongi Ben Ammar", "50 m2",5);
        Habitation h3=new HabitationPrive(10003, " Mongi Ben Ammar", "50 m2",3,260000);
        a.mettreSousVente(h1);
        a.mettreSousVente(h2);
        a.mettreSousVente(h3);
        a.vendre(h1,150000,"Mohamed Salah");
        a.afficherPrivee();
    }
}
