public class Point {
     private int abs;
     private int ord;
     private String nom;
     public Point(){
        this.abs=1;
        this.ord=1;
        this.nom="point 1";
     }
     public Point(int abs,int ord,String nom){
        this.abs=abs;
        this.ord=ord;
        this.nom=nom;
     }
     public int getAbs(){
        return this.abs;
     }
     public int getOrd(){
        return this.ord;
     }
     public String getNom(){
        return this.nom;
     }
     public void setAbs(int abs){
      this.abs=abs;
     }
     public void setOrd(int ord){
      this.ord=ord;
     }
     public void affiche(){
        System.out.println(this.nom+"("+this.abs+","+this.ord+")");
     }
     public double distance(Point p){
        return Math.sqrt(Math.pow(this.abs - p.abs, 2) + Math.pow(this.ord - p.ord, 2));
     }
}
