import javax.print.Doc;

public class Bibliotheque {
    private Documents[] listDocs;
    private int nombreDocuments;
    private int capaciteMax;
    public Bibliotheque(int capaciteMax){
        this.capaciteMax = capaciteMax;
        this.listDocs=new Documents[capaciteMax];
        this.nombreDocuments=0;
    }
    public int getCapaciteMax() {
        return capaciteMax;
    }
    public void Ajout_doc(Documents d){
        if (nombreDocuments<capaciteMax){
            if (nombreDocuments==0){
                listDocs[0]=d;
                nombreDocuments++;
            }
            else if (d.getNumId()>listDocs[nombreDocuments-1].getNumId()){
                listDocs[nombreDocuments]=d;
                nombreDocuments++;
            }
            else{
                int i=nombreDocuments-1;
                while (i>=0 && listDocs[i].getNumId()>d.getNumId()){
                    listDocs[i+1]=listDocs[i];
                    i--;
                }
                listDocs[i+1]=d;
                nombreDocuments++;
            }
        }
    }
    public void Supprimer_doc(int num){
        int f = -1;
        for(int i=0;i<nombreDocuments;i++){
            if(listDocs[i].getNumId()==num){
                f=i;
                break;
            }
        }
        if (f!=-1){
            for(int j=f;j<nombreDocuments;j++){
                listDocs[j]=listDocs[j+1];
            }
            nombreDocuments--;
        }
        else{
            System.out.println("Le document n'existe pas !");
        }

    }
    public void inventaire_doc(){
        for(int j=0;j<nombreDocuments;j++){
            listDocs[j].edition();
        }
    }
    public int getNombre_document(){
        return nombreDocuments;
    }
    public Bibliotheque liste_livre(){
        Bibliotheque b=new Bibliotheque(capaciteMax);
        System.out.println("--------------- Bibliotheque liste_livre ----------------");
        for(Documents d:listDocs){
            if ( d!=null && d.getType().equals("Livre")) {
                b.Ajout_doc(d);
            }
        }
        return b;
    }
    public Bibliotheque liste_article(){
        Bibliotheque b=new Bibliotheque(capaciteMax);
        System.out.println("--------------- Bibliotheque liste_article ----------------");
        for(Documents d:listDocs){
            if (d!=null && d.getType().equals("Article")) {
                b.Ajout_doc(d);
            }
        }
        return b;
    }
    public Bibliotheque liste_docsimples(){
        System.out.println("--------------- Bibliotheque liste_docsimples ----------------");
        Bibliotheque b=new Bibliotheque(capaciteMax);
        for(Documents d:listDocs){
            if (d!=null && d.getType().equals("Document")) {
                b.Ajout_doc(d);
            }
        }
        return b;
    }
    public Bibliotheque liste_periodique(){
        Bibliotheque b=new Bibliotheque(capaciteMax);
        System.out.println("--------------- Bibliotheque liste_periodique ----------------");
        for(Documents d:listDocs){
            if (d!=null && d.getType().equals("Periodique")) {
                b.Ajout_doc(d);
            }
        }
        return b;
    }

}
