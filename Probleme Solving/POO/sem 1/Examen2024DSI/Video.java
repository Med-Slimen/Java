import java.time.LocalDate;

public class Video extends BiiletTaggable{
    private String url;
    public Video(LocalDate datePub, String auteur, int capacite, String url) {
        super(datePub, auteur, capacite);
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
    @Override
    public String toString() {
        return "Video [ "+ super.toString()+ ", url=" + url + "]";
    }
}
