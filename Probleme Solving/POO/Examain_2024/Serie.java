public class Serie extends Content{
    private int nbEpisodes;
    private int dureeEpisode;
    public Serie(String title, String genre,boolean isFree,int nbEpisodes, int dureeEpisode) {
        super(title, genre,isFree);
        this.nbEpisodes = nbEpisodes;
        this.dureeEpisode = dureeEpisode;
    }
    public int getDuration() {
        return dureeEpisode;
    }
    public void afficheDetails(){
        System.out.println(super.toString()+" | duree Episode : "+dureeEpisode+" min | nbEpisodes : "+nbEpisodes);
    }
}
