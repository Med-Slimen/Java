public class Fiche {
    private String nom;
    private String numero;
    private String adresse;
    public Fiche(String nom, String numero, String adresse) {
        this.nom = nom;
        this.numero = numero;
        this.adresse = adresse;
    }
    @Override
    public String toString() {
        return "Nom : "+nom+"\nNumero : "+numero+"\nAdresse : "+adresse;
    }
}
