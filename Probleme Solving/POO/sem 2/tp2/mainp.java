public class mainp {
    public static void main(String[] args) {
        DossierPharmacie dp=new DossierPharmacie("P1");
        dp.nouveauPatient("Samir", new String[]{"M1", "M2"});
        dp.nouveauPatient("Wajdi", new String[]{"M2"});
        dp.nouveauPatient("9adour", new String[]{"M1","M2","M3"});
        System.out.println("Affichage du tous les patient");
        dp.affiche();
        dp.ajoutMedicament("Wajdi","M4");
        System.out.println("Affichage du patient wajdi apres l ajout du medicament M4");
        dp.affichePatient("Wajdi");
        System.out.println("Affichage du patient qui ont le medicament M1");
        System.out.println(dp.affichePatientAvecMedicament("M1"));
    }
}
