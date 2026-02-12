public class Dictionnaire {
    private  int nb_mots;
    private Mot_dict[] Dict;
    private String nomDict;
    public Dictionnaire(String nomDict){
        this.nomDict=nomDict;
        this.nb_mots=0;
        this.Dict=new Mot_dict[100];
    }
    public String getNom(){
        return this.nomDict;
    }
    @Override
    public String toString() {
        String msg="";
        for(int i=0;i<this.nb_mots;i++){
           msg=msg+"Mot = "+this.Dict[i].getMot()+" | Def = "+this.Dict[i].getDefinition() +"\n";
        }
        return msg;
    }
    public void Ajouter_Mot(Mot_dict mot){
        this.Dict[this.nb_mots]=mot;
        this.nb_mots++;
        trier();
    }
    public void trier() {
    Mot_dict aux;
    for (int i = 0; i < this.nb_mots - 1; i++) {
        for (int j = 0; j < this.nb_mots - i - 1; j++) {
            if (this.Dict[j].getMot().compareTo(this.Dict[j + 1].getMot()) > 0) {
                aux = this.Dict[j];
                this.Dict[j] = this.Dict[j + 1];
                this.Dict[j + 1] = aux;
            }
        }
    }
}

    public void Supprimer_Mot(Mot_dict mot){
        if (this.Dict[this.nb_mots-1]==mot) {
            this.nb_mots--;
        }
        else{
            int i=0;
            while (this.Dict[i]!=mot) {
                i++;
            }
            if (i==this.nb_mots) {
                System.out.println("mot not found");
            }
            else{
                int j;
                for(j=i;j<this.nb_mots-1;j++){
                    this.Dict[j]=this.Dict[j+1];
                }
                this.nb_mots--;
            }
        }
    }
    public String Recherche_dicho(String mot ){
        int i=0;
        while (this.Dict[i].getMot()!=mot) {
                i++;
        }
        if (i==this.nb_mots) {
                return "mot not found";
        }
        else{
            return this.Dict[i].getDefinition();
        }
    }
    public void Lister_dictionnaire(){
        System.out.println(this.Dict);
    }

   
    public int Nombre_synonyme(Mot_dict mot){
        int s=0;
        for(int i=0;i<this.nb_mots;i++){
           if (this.Dict[i].synonyme(mot)) {
            s++;
           }
        }
        return s-1;
    }
    
}
