import java.util.ArrayList;

public class mainEt {
    public static void main(String[] args) {
        ArrayList<Etudiant> es = new ArrayList<Etudiant>();
        Etudiant e1=new Etudiant("AE20","MED SM");
        e1.addNote(new Note("java",1));
        e1.addNote(new Note("math",3));
        e1.addNote(new Note("physic",2));
        e1.addNote(new Note("python",0.25));
        es.add(e1);
        Etudiant e2=new Etudiant("AS10","Ayoub Lassoued");
        e2.addNote(new Note("java",20));
        e2.addNote(new Note("math",-5));
        e2.addNote(new Note("physic",20));
        e2.addNote(new Note("python",20));
        es.add(e2);
        Stats s=new Stats();
        System.out.println("Meilleur Etudiant : "+s.meilleurEtudant(es));
        System.out.println("Mois bons Etudiant : "+s.moinsEtudiant(es));
        System.out.println("Meilleur note pour l etudiant : "+es.get(0).getNom()+" :"+s.meilleurNote(es.get(0)).note);
        System.out.println("Moins Note note pour l etudiant : "+es.get(0).getNom()+" :"+s.moinsNote(es.get(0)).note);
        System.out.println("Moyenne note pour l etudiant : "+es.get(0).getNom()+" :"+s.moyenne(es.get(0)));
        System.out.println("Moyenne pour tous les etudiants : "+s.moyenneEtudiants(es));
        System.out.println("Trie par matricule");
        s.trieEtudiantsParMatricule(es);
        s.affiche(es);
        System.out.println("Trie par nom");
        s.trieEtudiantsParNom(es);
        s.affiche(es);
        System.out.println("Trie par moyenne");
        s.trieEtudiantsParMoyenne(es);
        s.affiche(es);
    }
}
