public class ParcMain {
    public static void main(String[] args) {
        ParcAttraction p=new ParcAttraction("BouMendil",10);
        Attraction a1=new Attraction("PA1",10,new ConditionAge(5));
        Attraction a2=new Attraction("PA2",15,new ConditionAge(15));
        Attraction a3=new Attraction("PA3",15,new ConditionAge(5));
        Pers p1=new Pers(20,150,"3ezdin");
        Pers p2=new Pers(7,110,"9adour");
        Pers p3=new Pers(9,110,"mounir");
        try {
            a1.utilise(p1);
        }
        catch (AccesInterditException e){
            System.out.println(e.getMessage());
        }
        try {
            a2.utilise(p2);
        }
        catch (AccesInterditException e){
            System.out.println(e.getMessage());
        }
        try {
            a2.utilise(p1);
        }
        catch (AccesInterditException e){
            System.out.println(e.getMessage());
        }
        try {
            a3.utilise(p3);
        }
        catch (AccesInterditException e){
            System.out.println(e.getMessage());
        }
        try {
            a1.utilise(p2);
        }
        catch (AccesInterditException e){
            System.out.println(e.getMessage());
        }
        p.ajouteAttraction(a1);
        p.ajouteAttraction(a2);
        p.ajouteAttraction(a3);
        p.affiche();
        p.getRecette();
    }
}
