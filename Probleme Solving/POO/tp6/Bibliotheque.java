public class Bibliotheque {
    private Documents[] listDocs;
    private int nombreDocuments;
    private int capaciteMax;
    public Bibliotheque(int nombreDocuments, int capaciteMax){
        this.capaciteMax = capaciteMax;
        this.nombreDocuments = nombreDocuments;
        this.listDocs=new Documents[capaciteMax];
    }
    public int getCapaciteMax() {
        return capaciteMax;
    }
    public void Ajout_doc(Documents d){
        listDocs[nombreDocuments]=d;
        nombreDocuments++;
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
}
