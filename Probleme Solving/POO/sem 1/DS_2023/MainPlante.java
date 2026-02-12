public class MainPlante {
    public static void main(String[] args){
        System.out.println("Pepiniere GREEN HANDS");
        Pepiniere p = new Pepiniere();
        Fleur rose=new Fleur(null,30,12,15.99,"Rouge",2);
        Fleur tulipe=new Fleur("Tulipe",20,8,12.99,"Jaune",4);
        Arbre chene=new Arbre("Chene",200,60,89.99,"caduqe");
        Arbre sapin=new Arbre("Sapin",150,30,59.99,"persistant");
        rose.setNom("Rose");
        System.out.println("la "+rose.getNom()+" a le couleur "+rose.getCouleur());
        p.ajoutPlante(rose);
        p.ajoutPlante(tulipe);
        p.ajoutPlante(chene);
        p.ajoutPlante(sapin);
        p.afficherInventaire();
        System.out.println("Total Aborption CO2 "+p.totalAbsorptionTotaleCO2());
        System.out.println("Nombre d arbre caduqe dans la pepeniere "+p.compterArbresCaduques());
    }
}
