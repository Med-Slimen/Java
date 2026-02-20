import java.util.ArrayList;
import java.util.Collections;

public class Stats {
    public Note meilleurNote(Etudiant e){
        return Collections.max(e.notes);
    }
    public float moyenne(Etudiant e){
        return e.getValue();
    }
    public Note moinsNote(Etudiant e){
        return Collections.min(e.notes);
    }
    public float moyenneEtudiants(ArrayList<Etudiant> es){
        float s=0;
        for(Etudiant e:es){
            s+=e.getValue();
        }
        return s/es.size();
    }
    public Etudiant meilleurEtudant(ArrayList<Etudiant> es){
        return Collections.max(es);
    }
    public Etudiant moinsEtudiant(ArrayList<Etudiant> es){
        return Collections.min(es);
    }
    public void trieEtudiantsParMatricule(ArrayList<Etudiant> es){
        Collections.sort(es,new CompareMatricule());
    }
    public void trieEtudiantsParNom(ArrayList<Etudiant> es){
        Collections.sort(es,new CompareNom());
    }
    public void trieEtudiantsParMoyenne(ArrayList<Etudiant> es){
        Collections.sort(es,new CompareMoyenne());
    }
    public void affiche(ArrayList<Etudiant> es){
        for(Etudiant e:es){
            System.out.println(e);
        }
    }
}
