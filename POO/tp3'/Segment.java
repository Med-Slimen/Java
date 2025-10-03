public class Segment {
    private Point extr1;
    private Point extr2;

    public Segment(){
        this.extr1=new Point();
        this.extr2=new Point(6,4,"point 2");
     }
    @Override
    public String toString() {
        return "["+extr1.getNom()+"/ abs :"+extr1.getAbs()+"/ ord :"+extr1.getOrd()+","+extr2.getNom()+"/ abs :"+extr2.getAbs()+"/ ord :"+extr2.getOrd()+"]";
    }
    public double longeur(){
        return extr1.distance(extr2);
    }
    public boolean Appartient(Point p){
        double d1 = p.distance(extr1);
        double d2 = p.distance(extr2);
        double d = this.longeur();
        return d1+d2==d;
    }
    public void translateSeg(int a,int b){
        int ex1abs=this.extr1.getAbs()+a;
        int ex1ord=this.extr1.getOrd()+b;
        int ex2abs=this.extr2.getAbs()+a;
        int ex2ord=this.extr2.getOrd()+b;
        this.extr1.setAbs(ex1abs);
        this.extr1.setOrd(ex1ord);
        this.extr2.setAbs(ex2abs);
        this.extr2.setOrd(ex2ord);
    }
}