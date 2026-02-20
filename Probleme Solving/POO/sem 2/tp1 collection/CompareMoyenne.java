import java.util.Comparator;

public class CompareMoyenne implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        if(o1.getValue()<o2.getValue()){
            return -1;
        }
        else if(o1.getValue()>o2.getValue()){
            return 1;
        }
        return 0;
    }
}
