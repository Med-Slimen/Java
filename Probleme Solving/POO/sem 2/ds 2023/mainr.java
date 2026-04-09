public class mainr {
    public static void main(String[] args) {
        Candidat c=new Candidat("Mohamed Amine Slimene",2);
        c.ajoutComp("Java",70);
        c.ajoutComp("C++",30);
        c.ajoutComp("C#",50);
        Candidat c1=new Candidat("Ayoub Lassoued",1);
        c1.ajoutComp("Java",40);
        c1.ajoutComp("C++",60);
        c1.ajoutComp("Kotlin",50);
        Candidat c2 =new Candidat("Rochdi Ba3roura",5);
        c2.ajoutComp("JS",90);
        c2.ajoutComp("C++",10);
        c2.ajoutComp("C#",80);
        Recrutement r=new Recrutement("Programmation");
        r.ajoutOffre(1);
        r.ajoutOffre(2);
        r.postuler(1,c);
        r.postuler(1,c1);
        r.postuler(1,c2);
        System.out.println("Affichage du candidat trié par experience");
        System.out.println(r.trierCandidatsParExperience(1));
        System.out.println("Nombre du condidat qui a la competence java ( avec la meuilleur score )");
        r.SelectionCandidat(1,"Java");
    }
}
