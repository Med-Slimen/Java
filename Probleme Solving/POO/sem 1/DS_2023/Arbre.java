public class Arbre extends Plante {
    private String type_Feuillage;
    final double AbsorMoyenne=22;
    public Arbre(String nom, int hauteur, int age, double prix,String type_Feuillage){
        super(nom, hauteur, age, prix);
        this.type_Feuillage=type_Feuillage;
    }
    public double getAbsorMoyenne(){
        return AbsorMoyenne;
    }
    public String getType_Feuillage(){
        return type_Feuillage;
    }
    @Override
    public String toString() {
        return "nom : "+nom+" | hauteur : "+hauteur+" | age : "+age+" | prix : "+prix+" | type_Feuillage : "+type_Feuillage+" | AbsorMoyenne : "+AbsorMoyenne;
    }
    public void description(){
        System.out.println(toString());
    }
    public double absorptionCO2(){
        return super.hauteur>50?AbsorMoyenne+3 : AbsorMoyenne;
    }

}
