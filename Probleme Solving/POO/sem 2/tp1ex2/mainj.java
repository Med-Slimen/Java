import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.TreeMap;

public class mainj {

    public static void main(String[] args) {
        Annuaire a = new Annuaire();
        Scanner sc = new Scanner(System.in);
        boolean f=true;

        while(f){
            System.out.println("Menu :");
            System.out.println("\t 1 / '+' ajouter une fiche \n");
            System.out.println("\t 2 / '?' recherche une fiche \n");
            System.out.println("\t 3 / '!' afficher tous les fiches \n");
            System.out.println("\t 4 / '!!' affichage trié \n");
            System.out.println("Entrer : ");
            String c=sc.next();
        switch(c){
            case "+":
                a.addFiche();
                break;
            case "?":
                a.rechercheParNom();
                break;
            case "!":
                a.afficheMap(a.map);
                break;
            case "!!":
                TreeMap<String,Fiche> tMap = new TreeMap<>(a.map);
                a.afficheMap(tMap);
                break;
            default:
                f=false;
                break;
        }
        }
    }
}
