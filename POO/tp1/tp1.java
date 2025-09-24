class point{
    private String Nom;
    private int Abscisse;
    private int Ordonnee;
    public  point(String nom, int abscisse, int ordonnee){
        this.Nom = nom;
        this.Abscisse = abscisse;
        this.Ordonnee = ordonnee;
    }
    public  point(int abscisse, int ordonnee ){
        this.Abscisse = abscisse;
        this.Ordonnee = ordonnee;
    }
    public  point(String nom){
        this.Nom = nom;
    }
    public void Affiche(){
        System.out.println("Nom "+Nom+"("+Abscisse+","+Ordonnee+")");
    }
    public void TranslHoriz(int a){
        Ordonnee += a;
    }
    public void TranslVert(int a){
        Abscisse+=a;
    }
    public void Translation(int a,int b){
        Ordonnee += a;
        Abscisse+=a;
    }
    public boolean Coincide(point p){
        return this.Abscisse==p.Abscisse && this.Ordonnee==p.Ordonnee;
    }
    public String getNom(){
        return this.Nom;
    }
    public int getAbscisse(){
        return this.Abscisse;
    }
    public int getOrdonnée(){
        return this.Ordonnee;
    }
    public void setNom(String ch){
        this.Nom=ch;
    }
    public void setAbscisse(int a){
        this.Abscisse=a;
    }
     public void setOrdonnée(int a){
        this.Ordonnee=a;
    }
    public static void main (String [] args)
{
    point p1;
    p1 = new point (3, 5);
    point p2 = new point ("a");
    point p3 = new point ("b", 3,5);
    System.out.println("\n ---------------------------\n");
    System.out.println("les points créés sont :");
    p1.Affiche ();
    p2.Affiche ();
    p3.Affiche ();
    System.out.println("\n ---------------------------\n");
    if (p1.Coincide(p3) == true)
    System.out.println("Les 2 points p1 et p3 coïncident");
    else
    System.out.println("Les 2 points ne coïncident pas");
    System.out.println("\n ---------------------------\n");
    System.out.println("translation des point ");
    p1.TranslHoriz (4);
    p2.TranslVert (3);
    p3.Translation (5,2);
    p1.Affiche ();
    p2.Affiche ();
    p3.Affiche ();
    System.out.println("\n ---------------------------\n");
    System.out.println("modification des attributs des points") ;
    p1.setNom("SRI21");
    p2.setAbscisse(25);
    p3.setOrdonnée(50);
    p1.Affiche ();
    p2.Affiche ();
    p3.Affiche ();
    System.out.println("\n ---------------------------\n");
    System.out.println("utilisation des méthodes get");
    String x=p1.getNom();
    int y=p1.getAbscisse();
    int z=p1.getOrdonnée();
    System.out.println(" le nom du point p1 est : " + x);
    System.out.println(" son abscisse est : " + y);
    System.out.println(" son ordonnée est : " + z);
    p3.Nom="Test";
    p3.Abscisse=2;
    p3.Ordonnee=4;
    p3.Affiche ();
    }

}