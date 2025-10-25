public class BoiteCourrier {
    private Courrier[] courriers;
    private int n;
    public BoiteCourrier(int n){
        this.n = n;
        this.courriers = new Courrier[n];
    }
    public double affranchir(){
        double sum = 0;
        for (int i = 0; i < n; i++){
            if (courriers[i].estValide()){
                sum+=courriers[i].affranchir();
            }
        }
        return sum;
    }
    public int courriersInvalides(){
        int s=0;
        for (int i = 0; i < n; i++){
            if (!courriers[i].estValide()){
                s+=1;
            }
        }
        return s;
    }
    public void afficher(){
        for (int i = 0; i < n; i++){
            if (!courriers[i].estValide()){
                System.out.println("Courier Valide");
            }
            else{
                System.out.println("Courier Invalide");
            }
            courriers[i].decrire();

        }
    }
}
