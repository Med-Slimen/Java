public class Client {
    protected long id;
    protected String marque;
    protected int heurArriv;
    protected int heurSortie;
    public Client(long n){
        this.id=n;
    }
    public Client(long n,String m){
        this(n);
        this.marque=m;
    }
    @Override
    public String toString(){
        return "Client { le nom : "+id+" | Marque : "+marque+" | Heure Arrivee : "+heurArriv+" | Heure Sortie : "+heurSortie+" }";
    }
    public void arriver(int heurArriv){
        this.heurArriv=heurArriv;
    }
    public double sortir(int heureSortie){
        return heureSortie*2;
    }

}
