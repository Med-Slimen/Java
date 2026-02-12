public class Parking {
    private int max;
    private Client[] cTab;
    private int nbClient=0;
    public Parking(int m){
        this.max=m;
        this.cTab=new Client[max];
    }
    public void garer(Client c, int heureArrivee){
        if (nbClient<max){
            c.heurArriv=heureArrivee;
            cTab[nbClient]=c;
            nbClient++;
        }
        else{
            System.out.println("Parking is full");
        }
    }
    public int getNbClient(){
        return nbClient;
    }
    public Client[] getTab(){
        return cTab;
    }
}
