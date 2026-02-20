import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient implements Comparable<Patient> {
    private String nom;
    public Set<String> ordonnance;
    public Patient(String nom) {
        this.nom = nom;
        this.ordonnance = new HashSet<>();
    }
    public String getNom() {
        return nom;
    }
    public boolean ordonnanceVide(){
        return ordonnance.isEmpty();
    }
    public void ajouterMedicament(String m){
        this.ordonnance.add(m);
    }
    public void affiche(){
        System.out.println("Nom du patient : "+this.getNom());
        for(String m : this.ordonnance){
            System.out.println(m);
        }
    }
    public boolean contientMedicament(String m){
        return this.ordonnance.contains(m);
    }
    @Override
    public int compareTo(Patient p) {
        return this.nom.compareTo(p.nom);
    }
    public void trieOrdonnance(){
        this.ordonnance=new TreeSet<>(this.ordonnance);
    }

}
