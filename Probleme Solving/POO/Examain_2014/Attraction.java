public class Attraction {
    private String nom;
    private double cout;
    private ConditionAge conditionAge;
    private int nbrPersonne=0;
    private double recette=0;
    public Attraction(String nom, double cout, ConditionAge conditionAge) {
        this.nom = nom;
        this.cout = cout;
        this.conditionAge = conditionAge;
    }
    public void affiche(){
        System.out.println("nom : "+nom+"| cout : "+cout+"| conditionAge : "+conditionAge.getAgeMin()+"| nbrPersonne : "+nbrPersonne+"| recette : "+recette);
    }
    public double getRecette(){
       return recette;
    }
    public void utilise(Pers p) throws AccesInterditException{
        if (conditionAge.accesPossible(p)){
            nbrPersonne++;
            recette+=cout;
        }
        else{
        throw new AccesInterditException(p.getNom()+" n a pas l access a l attraction "+nom);
    }

}
}
