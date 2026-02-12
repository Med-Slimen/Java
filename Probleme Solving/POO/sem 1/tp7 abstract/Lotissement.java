public class Lotissement implements GestionPropriete  {
    protected Proriete [] tabProp;
    protected int nombre=0;
    public Lotissement(int capacite){
        tabProp = new Proriete[capacite];
    }
    public Proriete getproprieteByIndex(int i){
        if(i>=0 && i<nombre)return tabProp[i];
        return null;
    }
    public int getnbPiece(){
        int n=0;
        for(int j=0;j<tabProp.length;j++){
            if(tabProp[j] instanceof ProrietePrivee){
                n+=((ProrietePrivee)tabProp[j]).getNbPiece();
            }
        }
        return n;
    }
    public void afficherPropriete(){
        for(int j=0;j<nombre;j++){
            System.out.print(tabProp[j].toString()+" | Montant a payer : "+tabProp[j].calcullmport()+"\n");
        }
    }
    public boolean ajouter(Proriete p){
        if (nombre<MAX_PROPRIETES){
            tabProp[nombre] = p;
            nombre++;
            return true;
        }
        return false;
    }
    public boolean supprimer(Proriete p){
        int i;
       for (i = 0; i < nombre; i++) {
           if (tabProp[i].id == p.id){
               break;
           }
       }
       if (i==nombre-1){
           return false;
       }
       else{
           for (int j = i+1; j < nombre; j++) {
               tabProp[j-1] = tabProp[j];
           }
           nombre--;
           return true;
       }

    }
}
