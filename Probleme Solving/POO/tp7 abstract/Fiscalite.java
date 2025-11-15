public class Fiscalite {
    public static void main(String[] args) {
        Person p1=new Person(1,"med","sm");
        Person p2=new Person(2,"ayoub","las");
        Person p3=new Person(3,"pedri","joslo");
        Lotissement l=new Lotissement(10);
        l.ajouter(new ProrietePrivee(1,p1,"Corniche",350,4));
        l.ajouter(new Villa(2,p2,"Dar Chaabane", 400,6,true));
        l.ajouter(new Appartement(3,p2,"Hammamet",1200,8, 3));
        l.ajouter(new ProprieteProfessionnelle(4,p3,"Korba", 1000, 50,true));
        l.ajouter(new ProprieteProfessionnelle(5,p1,"Bir Bouragba",2500, 400, false));
        l.afficherPropriete();
        System.out.println("Nombre global des piece : "+l.getnbPiece());
        double min=999;
        int k=0;
        for(int j=0;j<l.nombre;j++){
            if(l.tabProp[j] instanceof ProrietePrivee){
                if (((ProrietePrivee)l.tabProp[j]).calcullmport()<min){
                    min=((ProrietePrivee)l.tabProp[j]).calcullmport();
                    k=j;
                }
            }
        }
        System.out.println("la proprietaire  : "+l.tabProp[k] + " le montant : "+min);
        l.supprimer(l.tabProp[2]);
        l.afficherPropriete();
        System.out.println("--- Lotissement Privé ---");
        Lotissement lt= new LotissementPrivee(10);
        lt.ajouter(new ProrietePrivee(1,p1,"Corniche",350,4));
        lt.ajouter(new Villa(2,p2,"Dar Chaabane", 400,6,true));
        lt.ajouter(new Appartement(3,p2,"Hammamet",1200,8, 3));
        lt.ajouter(new ProprieteProfessionnelle(4,p3,"Korba", 1000, 50,true));
        lt.ajouter(new ProprieteProfessionnelle(5,p1,"Bir Bouragba",2500, 400, false));
        lt.afficherPropriete();
        System.out.println("--- Supprimé l adress Dar chaabane ---");
        lt.supprimer(lt.tabProp[1]);
        lt.afficherPropriete();
        System.out.println("Get proprité by index :");
        System.out.println(lt.getproprieteByIndex(1));
}}
