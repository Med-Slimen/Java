import java.util.ArrayList;

public class Etudiant implements Comparable<Etudiant>,Statisticable{
    private String matricule;
    private String nom;
    public ArrayList<Note> notes=new ArrayList<>();
    public Etudiant(String matricule, String nom) {
        this.matricule = matricule;
        this.nom = nom;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void addNote(Note note) {
        this.notes.add(note);
    }
    @Override
    public String toString() {
        return "Matricule: " + matricule + ", Nom: " + nom + "Moyenne: " + this.getValue();
    }
    @Override
    public float getValue() {
        int s=0;
        for(Note n : this.notes){
            s+=n.note;
        }
        return (float) s /this.notes.size();
    }

    @Override
    public int compareTo(Etudiant e) {
        if(this.getValue()>e.getValue()){
            return 1;
        }
        else if(this.getValue()<e.getValue()){
            return -1;
        }
        return 0;
    }
}
