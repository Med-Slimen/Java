public class LotissementPrivee extends Lotissement {
    public LotissementPrivee(int capacite){
        super(capacite);
    }
    public boolean ajouter(Proriete p){
        if (p instanceof ProrietePrivee){
                return super.ajouter(p);
        }
            return false;
        }
    public ProrietePrivee getproprieteByIndex(int i){
        if(i>=0 && i<nombre && tabProp[i] instanceof ProrietePrivee)return  (ProrietePrivee)tabProp[i];
        return null;
    }
    public int getnbPiece(){
        return super.getnbPiece();
    }
}
