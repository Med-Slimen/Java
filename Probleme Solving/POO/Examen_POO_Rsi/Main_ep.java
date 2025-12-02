public class Main_ep {
    public static void main(String[] args) {
        Epreuve e=new Epreuve("Tennis",10);
        Athlete a1=new Athlete(1,"3ezdin");
        Athlete a2=new Athlete(2,"9adour");
        Athlete a3=new Athlete(3,"mounir");
        e.ajoutAthlete(a1);
        e.ajoutAthlete(a2);
        e.ajoutAthlete(a3);
        Resultat r1=new ResultatDistance(20.2);
        Resultat r2=new ResultatDistance(25);
        Resultat r3=new ResultatDistance(30);
        try{
            e.fixeResultat(1,r1);
            e.fixeResultat(2,r2);
            e.fixeResultat(3,r3);
        }
        catch(IllegalStateException s){
            System.out.println(s.getMessage());
        }

        e.terminer();
        System.out.println("Le Vinqueur :");
        System.out.println(e.getVinqueur());
        System.out.println("Le Meuilleur Resultat :");
        System.out.println(e.getRecordOlymique());


    }
}
