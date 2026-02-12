public class Epreuve {
    private String denomination;
    private Athlete[] tabA;
    private int nbA=0;
    private int max;
    boolean etat=false;
    public Epreuve(String denomination,int max) {
        this.denomination = denomination;
        this.max = max;
        this.tabA = new Athlete[max];
    }
    @Override
    public String toString() {
        String s="";
        for(int i=0;i<nbA;i++){
            s+=tabA[i].getNom()+" | ";
        }
        return "denomination : "+denomination+" | etat :"+(etat ? "Terminé | " : "Non terminé | ")+" Les Athletes : \n"+s+"\n--------";
    }
    public void ajoutAthlete(Athlete a){
        if(nbA<max){
            tabA[nbA]=a;
            nbA++;
        }
        else{
            System.out.println("Le nombre maximum est atteint");
        }
    }
    public void terminer(){
        this.etat=true;
    }
    public boolean estTerminer(){
        return this.etat;
    }
    public Resultat getRecordOlympique(){
        Resultat r=tabA[0].getResultat();
        for(int i=1;i<nbA;i++){
            if (tabA[i].getResultat().compareTo(r)==1){
                r=tabA[i].getResultat();
            }
        }
        return r;
    }
    public Athlete getVinqueur(){
        if (estTerminer()){
            Resultat r=getRecordOlympique();
            for (int i=0;i<nbA;i++){
                if(tabA[i].getResultat().compareTo(r)==0){
                    return tabA[i];
                }
            }
        }
        return null;
    }
    public void fixerResultat(int id,Resultat r) throws IllegalStateException{
        boolean b=false;
        if(!estTerminer()){
            for (int i=0;i<nbA;i++){
                if(tabA[i].getId()==id){
                    tabA[i].setResultat(r);
                    b=true;
                    break;
                }
            }
            if(!b){
                throw new IllegalStateException("L athlete n est pas inscrit");
            }
        }
        else{
            throw new IllegalStateException(" exception L epreuve est terminé");
        }
    }
    public Resultat getResultat(int id){
        for (int i=0;i<nbA;i++){
            if(tabA[i].getId()==id && tabA[i].getResultat()!=null){
                return tabA[i].getResultat();
            }
        }
        return null;
    }

}
