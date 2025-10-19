public class TestSegment {
    
    public static void  main(String args[]){
        Segment seg1=new Segment();
        Segment seg2=new Segment();
        System.out.println("distance du segment 1 : "+seg1.longeur());
        System.out.println("distance du segment 2 : "+seg2.longeur());
        System.out.println("Carateristiue du segmennt 1 :"+seg1);
        System.out.println("Carateristiue du segmennt 2 :"+seg2);
        seg2.translateSeg(7, 5);
        System.err.println("------ Aprés modification -------");
        System.out.println("Carateristiue du segmennt 1 :"+seg1);
        System.out.println("Carateristiue du segmennt 2 :"+seg2);
    }
}
