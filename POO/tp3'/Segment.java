public class Segment {
    private Point extr1;
    private Point extr2;

    public Segment(){
        this.extr1=new Point();
        this.extr2=new Point(1,2,"point 2");
     }

    @Override
    public String toString() {
        return "["+extr1+" "+extr2+"]";
    }
    public double longeur(){
        return extr1.distance(extr2);
    }
    public void Appartient(Point p){
           
}