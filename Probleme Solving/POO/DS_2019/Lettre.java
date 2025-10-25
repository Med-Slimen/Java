public class Lettre extends Courrier {
    private double poids;
    private String format;
    public Lettre(boolean modeE,String adresse,double poids,String format){
        super(modeE,adresse);
        this.poids=poids;
        this.format=format;
    }
    @Override
    public void decrire(){
        System.out.println("mode d’expédition : "+super.modeE+", adresse : "+super.adresse + ", poids : "+poids+", format : "+format);
    }
    @Override
    public double affranchir(){
        if (estValide()){
            double montant=0;
            if (format=="A4"){
                montant=2.5+0.5*poids;
            }
            else{
                montant=3.5+0.5*poids;
            }
            if (super.modeE){
                montant=montant*2;
            }
            return montant;
        }
        else{
            return 0;
        }
    }
}
