import java.util.Objects;

public class Personne implements Comparable<Personne> {
    private String nomPrenom ;
    private String pseudo;
    public Personne(String nomPrenom, String pseudo) {
        this.nomPrenom = nomPrenom;
        this.pseudo = pseudo;
    }
    public String getNomPrenom() {
        return nomPrenom;
    }
    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    @Override
    public String toString() {
        return "personne [nomPrenom=" + nomPrenom + ", pseudo=" + pseudo + "]";
    }
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Personne)){
            return false;
        }
        else{
            Personne p=(Personne) o;
            return this.getPseudo().equals(p.getPseudo()) && this.getNomPrenom().equals(p.getNomPrenom());
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(getPseudo(), getNomPrenom());
    }
    @Override
    public int compareTo(Personne p) {
        /*
        int res = this.getNomPrenom().compareTo(p.getNomPrenom());

        if (res != 0) {
            return res; // nomPrenom decides
        }

        return this.getPseudo().compareTo(p.getPseudo()); // tie-breaker*/
        return this.getPseudo().compareTo(p.getPseudo());
    }
}
