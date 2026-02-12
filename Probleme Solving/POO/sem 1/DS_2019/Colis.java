public class Colis extends Courrier {
    private double poids;
    private double volume;
    public Colis(boolean modeE,String adresse,double poids,double volume){
        super(modeE,adresse);
        this.poids=poids;
        this.volume=volume;
    }
    @Override
    public void decrire(){
        System.out.println("mode d’expédition : "+super.modeE+", adresse : "+super.adresse + ", poids : "+poids+", volume : "+volume);
    }
    @Override
    public double affranchir(){
        if (estValide()){
            return 0.25*volume+poids*1.0;
        }
        else{
            return 0;
        }
    }
}
