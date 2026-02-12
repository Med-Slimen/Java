public class Movie extends Content {
    private int duree;
    public Movie(String title, String genre, boolean isFree,int duree) {
        super(title, genre,isFree);
        this.duree = duree;
    }
    public int getDuration() {
        return duree;
    }
    public void afficheDetails(){
        System.out.println(super.toString()+" | duree : "+duree);
    }
}