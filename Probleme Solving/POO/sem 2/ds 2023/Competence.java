public class Competence implements Comparable<Competence> {
    private String nom;
    private int score;
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public Competence(String nom, int score) {
        this.nom = nom;
        this.score = score; }
    @Override
    public String toString() {
        return"Competence [nom=" + nom + ", score=" + score + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if(this.score==((Competence)obj).score &&
                (nom.compareTo(((Competence)obj).nom)==0))
            return true;
        else return false;
    }
    @Override
    public int compareTo(Competence c){
        return Integer.compare(this.getScore(),c.getScore());
    }
}