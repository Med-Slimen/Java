import java.io.File;

public class FilenameFilter {
    private char lettre;
    public FilenameFilter(char lettreDebut) {
        lettre = lettreDebut;
    }
    public boolean accept(File repFiltre, String nom) {
        return nom.charAt(0)==lettre;
    }
}
