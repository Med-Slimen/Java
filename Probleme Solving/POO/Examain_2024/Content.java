abstract class Content implements Streamable {
    protected String title;
    protected String genre;
    protected boolean isFree ;
    public Content(String title, String genre,boolean isFree) {
        this.title = title;
        this.genre = genre;
        this.isFree = isFree;
    }
    abstract void afficheDetails();
    public void play() {
        System.out.println("lecture de  " + title+ " " + genre);
    }
    @Override
    public String toString() {
        return "tite : "+title + " | genre : " + genre;
    }
}
