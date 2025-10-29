public class Fleur extends Plante {
    private String couleur;
    private int moisF;
    public Fleur(String nom, int hauteur, int age, double prix,String couleur, int moisF) {
        super(nom, hauteur, age, prix);
        this.couleur = couleur;
        this.moisF = moisF;
    }
    @Override
    public String toString(){
        return "nom : "+nom+" | hauteur : "+hauteur+" | age : "+age+" | prix : "+prix+" | couleur : "+couleur+" | moisF : "+moisF;
    }
    public void description(){
        System.out.println(toString());
        fleurir();
    }
    public String getCouleur() {
        return couleur;
    }
    public void fleurir(){
        if (moisF==4 || moisF==5 || moisF==6){
            System.out.println("Fleur est en fleurs");
        }
        else{
            System.out.println("Fleur n est pas en fleurs");
        }
    }

}
