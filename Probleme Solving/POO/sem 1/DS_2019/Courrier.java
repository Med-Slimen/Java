public class Courrier {
    protected boolean modeE;
    protected String adresse;
    protected static double tarif=0.5;
    public Courrier(boolean modeE,String adresse){
        this.modeE=modeE;
        this.adresse=adresse;
    }
    public boolean estValide(){
        return adresse!=null;
    }
    public void decrire(){
        System.out.println("mode d’expédition : "+modeE+", adresse : "+adresse);
    }
    public double affranchir(){
        if (estValide()){
            if (modeE){
                return tarif;
            }
            else{
                return tarif*2;
            }
        }
        else{
            return 0;
        }
    }
}
