public class TestBibliotheque {
    public static void main(String[] args) {
        Bibliotheque b=new Bibliotheque(20);
        Documents doc1=new Documents("test1",1,10);
        Documents doc2=new Documents("test2",2,20);
        Article art1=new Article("Med","test",3,30);
        Periodique per1=new Periodique(10,"testPer",6,15);
        Livres l1=new Livres("Ayoub","Med","testTitre",8,10);
        b.Ajout_doc(doc1);
        b.Ajout_doc(doc2);
        b.Ajout_doc(art1);
        b.Ajout_doc(l1);
        b.Ajout_doc(per1);
        b.inventaire_doc();
        System.out.println("Aprés suppression du article");
        b.Supprimer_doc(3);
        b.inventaire_doc();
        b.liste_livre().inventaire_doc();
        b.liste_periodique().inventaire_doc();
        b.liste_article().inventaire_doc();
        b.liste_docsimples().inventaire_doc();
    }
}
