import java.util.Comparator;

public class CompareMatricule implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        return o1.getMatricule().compareTo(o2.getMatricule());
    }
}
