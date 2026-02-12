public class main_e {
    public static void main(String[] args) {
        Epreuve ep=new Epreuve("Lancement du poids",8);
        Athlete a1=new Athlete(1,"3ezdin","Jamaique");
        Athlete a2=new Athlete(2,"9adour","USA");
        Athlete a3=new Athlete(3,"tijeni","Bresil");
        ep.ajoutAthlete(a1);
        ep.ajoutAthlete(a2);
        ep.ajoutAthlete(a3);
        System.out.println(ep);
        try{
            /*ep.fixerResultat(4,new ResultatDistance(90.2));*/
            ep.fixerResultat(1,new ResultatDistance(90));
            ep.fixerResultat(2,new ResultatDistance(90.17));
            ep.fixerResultat(3,new ResultatDistance(90.2));
            System.out.println("La resultat du l athlete "+a1.getNom()+" :"+ep.getResultat(1));
            System.out.println("Le record olympique du l epreuve : "+ep.getRecordOlympique());
            ep.terminer();
            /*ep.fixerResultat(1,new ResultatDistance(20));*/
            System.out.println("L epreuve est terminé");
            System.out.println("Le vanqueur est :"+ep.getVinqueur().getNom());

        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }
}
