import java.time.LocalDate;

public class Billet implements Publiable {
    protected LocalDate datePub;
    protected String auteur;
    public Billet(LocalDate datePub, String auteur) {
        this.datePub = datePub;
        this.auteur = auteur;
    }
    @Override
    public String toString() {
        return "Billet : { datePub : "+datePub+", auteur : "+auteur+"}";
    }
    @Override
    public LocalDate getDatePublication() {
        return datePub;
    }

    @Override
    public String getAuteur() {
        return auteur;
    }
}
