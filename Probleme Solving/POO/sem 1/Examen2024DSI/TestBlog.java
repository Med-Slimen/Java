import java.time.LocalDate;

public class TestBlog {

    public static void main(String[] args) {
        try {
            // --------------------------
            // 1. TEST Message & Billet
            // --------------------------
            System.out.println("=== TEST MESSAGE ===");
            Message m1 = new Message(LocalDate.of(2024, 1, 10), "Ali", "Bonjour à tous !");
            Message m2 = new Message(LocalDate.of(2024, 2, 3), "Sami", "Java est un super langage !");
            System.out.println(m1);
            System.out.println(m2);

            // --------------------------
            // 2. TEST BilletTaggable + Image + Video
            // --------------------------
            System.out.println("\n=== TEST BILLET TAGGABLE ===");

            Image img = new Image(LocalDate.of(2024, 3, 1), "Ali", 5, "https://site.com/img1.png");
            img.ajoutTag("geek");
            img.ajoutTag("gaming");
            img.ajoutTag("informatique");
            img.ajoutTag("gaming"); // doublon → ne doit PAS s’ajouter
            System.out.println(img);

            Video vid = new Video(LocalDate.of(2024, 1, 15), "Sami", 3, "http://video.com/v1.mp4");
            System.out.println(vid);

            // Test suppression tag
            img.supprimeTag("gaming");
            System.out.println("Après suppression tag: " + img);

            // --------------------------
            // 3. TEST Blog
            // --------------------------
            System.out.println("\n=== TEST BLOG ===");

            Blog blog = new Blog("Tech Blog", 10);

            // Post de billets
            blog.post(m1);
            blog.post(m2);
            blog.post(img);

            // Vidéo non sécurisée → doit lever InvalidURLException
            try {
                blog.post(vid);
            } catch (InvalidURLException e) {
                System.out.println("ERREUR URL DÉTECTÉE : " + e.getMessage());
            }

            // --------------------------
            // 4. TEST getNombreBilletsTaggables()
            // --------------------------
            System.out.println("\nNombre de billets taggables : "
                    + blog.getNombreBilletsTaggables());

            // --------------------------
            // 5. TEST Recherche billets taggables par auteur
            // --------------------------
            System.out.println("\n=== Billets taggables de Ali ===");
            Publiable[] res1 = blog.RechercheBilletsTaggablesParAuteur("Ali");
            for (Publiable p : res1)
                if (p != null)
                    System.out.println(p);

            // --------------------------
            // 6. TEST billet le plus récent
            // --------------------------
            System.out.println("\n=== Billet le plus récent ===");
            System.out.println(blog.getPlusRecentBillet());

            // --------------------------
            // 7. TEST Recherche billets par contenu
            // --------------------------
            System.out.println("\n=== Recherche par contenu ===");
            String[] mots = {"Java", "super"};
            Publiable[] res2 = blog.RechercheBilletsParContenu(mots);
            for (Publiable p : res2)
                if (p != null)
                    System.out.println(p);

        } catch (Exception e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
