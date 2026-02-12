public class ResultatDistance implements Resultat{
    private double distance;
    public ResultatDistance(double distance){
        this.distance=distance;
    }
    @Override
    public String toString() {
        return "ResultatDistance{" + "distance=" + distance + '}';
    }
    @Override
    public void affiche() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Resultat r) {
        if (r instanceof ResultatDistance) {
            if(this.distance>((ResultatDistance)r).distance){
                return 1;
            }
            else if(this.distance<((ResultatDistance)r).distance){
                return -1;
            }
            else{
                return 0;
            }
        }
        return -2;
    }
}
