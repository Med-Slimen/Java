abstract class Ustensile {
    protected int annee;
    public Ustensile(int annee) {
        this.annee = annee;
    }
    public int  calculeValeur() {
        if (2025-annee<50){
            return 0;
        }
        else{
            return 2025-annee-50;
        }
    }
}
