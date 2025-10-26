public class MainC {
    public static void main(String[] args) {
        BoiteCourrier b=new BoiteCourrier(5);
        b.courriers[0]=new Courrier(true,"Cité ezzouhour");
        b.courriers[1]=new Lettre(false,"Ariana",20,"A4");
        b.courriers[2]=new Colis(true,"Ben aarous",5.2,5.4);
        b.courriers[3]=new Lettre(true,"Manzah",10.5,"A3");
        b.courriers[4]=new Lettre(false,null,8.5,"A3");
        System.out.println("Total d affrancir : "+b.affranchir());
        System.out.println("Les Courriers Invalides : "+b.courriersInvalides());
        b.afficher();
    }
}

