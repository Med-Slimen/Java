class personne {
    private String nom;
    private String prenom;
    private int age;
    private String sexe;
    public personne(){
        this.nom="Med";
        this.prenom="Ben Ali";
        this.age=30;
        this.sexe="Homme";
    }
    public personne(String nom,String prenom,int age,String sexe){
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.sexe=sexe;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public int getAge(){
        return this.age;
    }
    public String getSexe(){
        return this.sexe;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setSexe(String sexe){
        this.sexe=sexe;
    }
    public void affiche(){
        System.out.println("\nLe nom : "+nom+"\n Le prenom :"+prenom+"\n l age : "+age+"\n sexe : "+sexe);
    }
    public boolean sameLastName(personne p){
        return this.nom==p.nom;
    }
    public static void main(String args[]){
        personne p1 = new personne("Slimene","Med",20,"Homme");
        personne p2 = new personne("Lassoued","Ayoub",21,"Homme");
        p1.affiche();
        p2.affiche();
        if (p1.sameLastName(p2)) {
            System.out.println("meme nom de famille");
        }
        else{
            System.out.println("n est pas le meme nom de famille");
        }
        if (p1.getAge()>p2.getAge()){
            System.out.println(p1.getNom()+" est le plus agé");
        }
        else if(p1.getAge()<p2.getAge()){
            System.out.println(p2.getNom()+" est le plus agé");
        }
        else{
            System.out.println("meme age");
        }
    }
}
