import java.time.LocalDate;

public class Message extends Billet {
    private String message;
    public Message(LocalDate datePub, String auteur, String message) {
        super(datePub,auteur);
        this.message=message;
    }
    public String getMessage() {
        return message;
    }
}
