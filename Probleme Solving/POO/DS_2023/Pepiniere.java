public class Pepiniere {
    private Plante[] inventaire;
    private int MAX_PLANTES=1000;
    private int nombreDePlantes=0;
    public Pepiniere(){
        inventaire = new Plante[MAX_PLANTES];
    }
    public void ajoutPlante(Plante plante){
        if(nombreDePlantes<MAX_PLANTES){
            inventaire[nombreDePlantes] = plante;
            nombreDePlantes++;
        }
        else{
            System.out.println("atteint le nombre maximum des plante");
        }
    }
    public void afficherInventaire(){
        for(int i=0;i<nombreDePlantes;i++){
            inventaire[i].description();
        }
    }
    public double totalAbsorptionTotaleCO2(){
        double s=0;
        for(int i=0;i<nombreDePlantes;i++){
            if(inventaire[i] instanceof Arbre){
                s+=((Arbre)inventaire[i]).absorptionCO2();
            }
        }
        return s;
    }
    public int compterArbresCaduques(){
        int caduque=0;
        for(int i=0;i<nombreDePlantes;i++){
            if(inventaire[i] instanceof Arbre){
                if (((Arbre)inventaire[i]).getType_Feuillage().equals("caduqe")){
                    caduque++;
                }
            }
        }
        return caduque;
    }
}
