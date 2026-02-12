public class User {
    private String nom;
    private boolean isSubscribed;
    private Content[] watchedContent;
    private int nbWatched=0;
    final int MAX_WATCHED=100;
    public User(String nom,boolean isSubscribed){
        this.nom=nom;
        this.isSubscribed=isSubscribed;
        watchedContent=new Content[50];
    }
    @Override
    public String toString() {
        return "User{" + "nom=" + nom + ", isSubscribed=" + isSubscribed + '}';
    }
    public Content[] getWatchedContent() {
        return watchedContent;
    }
    public boolean getIsSubscribed(){
        return isSubscribed;
    }
    public int getNbWatched(){
        return nbWatched;
    }
    public String getNom(){
        return nom;
    }
    public boolean canPlay(Content content){
        if (content.isFree){
            return true;
        }
        else{
            if(isSubscribed){
                return true;
            }
            return  false;
        }
    }
    public void addWatchedContent(Content content){
        if (nbWatched<MAX_WATCHED){
            watchedContent[nbWatched]=content;
            nbWatched++;
        }
        else {
            System.out.println("Taille maximale atteint !");
        }
    }
    public boolean exist(String genre,String[] tabG){
        for (int i = 0; i< tabG.length; i++){
            if (tabG[i]!=null && tabG[i].equals(genre)){
                return true;
            }
        }
        return false;
    }
    public String[] getWatchedGenres() {
        String[] genres=new String[nbWatched];
        int j=0;
        for (int i=0;i<nbWatched;i++){
            if (!exist(watchedContent[i].genre,genres)){
                genres[j]=watchedContent[i].genre;
                j++;
            }
        }
        return genres;
    }
}
