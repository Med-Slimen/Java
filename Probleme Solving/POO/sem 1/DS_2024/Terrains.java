public class Terrains extends Carte{
    private char c;
    public Terrains(char c) {
        super(0);
        this.c=c;
    }
    @Override
    public String toString() {
        return "Cout : "+super.cout+" | Couleur : "+c;
    }
}
