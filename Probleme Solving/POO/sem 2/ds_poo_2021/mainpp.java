public class mainpp {
    public static void main(String[] args) {
        ReseauSocial r=new ReseauSocial();
        Personne p1=new Personne("Med sm","Miosu");
        r.ajouterUtilisateur(p1);
        r.AjouterSuiveur(p1,new Personne("Ali per1","Aloulou"));
        r.AjouterSuiveur(p1,new Personne("Ali per2","Aloulou"));
        r.AjouterSuiveur(p1,new Personne("Ali per3","Aloulou"));
        r.AjouterSuiveur(p1,new Personne("Ali per4","Aloulou"));
        r.AjouterSuiveur(p1,new Personne("Ali per5","Aloulou"));
        Personne p2=new Personne("Ayoub Lasoued","Loulou");
        r.ajouterUtilisateur(p2);
        r.AjouterSuiveur(p2,new Personne("caaci coucou","coucou"));
        r.AjouterSuiveur(p2,new Personne("rami kechta","rourou"));
        r.AjouterSuiveur(p2,new Personne("Ali","Aloulou"));
        System.out.println("--- List de resau sociale : --- ");
        r.affiche();
        System.out.println("List du tous les suiveurs");
        System.out.println(r.ListeUtilisateursSuiveurs());
        System.out.println("--- List du tous les suiveurs ( trié par pseudo ) --- ");
        r.TrierListeSuiveurs();
        System.out.println("--- L utilisateur qui a le max suiveurs");
        System.out.println(r.MaxSuiveurs());
    }
}
