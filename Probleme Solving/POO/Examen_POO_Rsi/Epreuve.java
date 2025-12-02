public class Epreuve {
    private String denomination;
    private Athlete[] tabA;
    private int max;
    private int nb_ath=0;
    private boolean etat=false;
    public Epreuve(String denomination,int max) {
        this.denomination = denomination;
        this.max = max;
        this.tabA = new Athlete[max];
    }
    @Override
    public String toString() {
        String s="Denomination: " + this.denomination + "| Etat: " + (etat ? "Terminé" : "Non Terminé")+"\n Les Athlete : \n";
        for(int i=0;i<this.nb_ath;i++){
            s+=tabA[i].getNom()+" | ";
        }
        return s;
    }
    public void ajoutAthlete(Athlete a){
        if(nb_ath<max){
            tabA[nb_ath]=a;
            nb_ath++;
        }
        else{
            System.out.println("Le nombre maximun des  Athletes est atteint");
        }
    }
    public void terminer (){
        this.etat=true;
    }
    public boolean estTerminee(){
        return this.etat;
    }
    public Resultat getRecordOlymique(){
        Resultat r=this.tabA[0].getResultat();
        for(int i=0;i<this.nb_ath;i++){
            try{
            if(this.tabA[i].getResultat().compareTo(r)==1){
                r=this.tabA[i].getResultat();
            }
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return r;
    }
    public Athlete getVinqueur(){
        if(this.estTerminee()){
            for (int i=0;i<this.nb_ath;i++){
                if(this.tabA[i].getResultat()==this.getRecordOlymique()){
                    return this.tabA[i];
                }
            }
            return null;
        }
        return null;
    }
    public void fixeResultat(int id, Resultat r) throws IllegalStateException{
        if(!this.estTerminee()){
            for(int i=0;i<this.nb_ath;i++){
                if(this.tabA[i].getId()==id){
                    this.tabA[i].setResultat(r);
                    break;
                }
            }
        }
        else{
            throw new IllegalStateException("Epreuve terminé");
        }
    }
    public Resultat getResultat(int id){
        for(int i=0;i<this.nb_ath;i++){
            if(this.tabA[i].getId()==id && this.tabA[i].getResultat()!=null){
                return this.tabA[i].getResultat();
            }
        }
        return null;
    }
}
