public class MainParking {
    public static void main(String[] args) {
        Parking p=new Parking(100);
        Client c1=new Client(123123," Toyota yaris");
        Client c2=new Abonne(124124," Suzuki",100);
        p.garer(c1,8);
        p.garer(c2,10);
        Client[] cTab=p.getTab();
        for(int i=0;i<p.getNbClient();i++){
            System.out.println(cTab[i]);
        }
        for(int j=0;j<p.getNbClient();j++){
            if(cTab[j] instanceof Abonne){
                System.out.println(cTab[j]);
            }
        }
    }
}
