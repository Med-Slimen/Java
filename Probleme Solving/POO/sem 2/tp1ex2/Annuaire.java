import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Annuaire {
    Map<String,Fiche> map = new HashMap<String,Fiche>();
    public void rechercheParNom(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrer le nom :");
        String key=sc.nextLine();
        System.out.println("Le fiche qui a le nom "+key+ "\n "+this.map.get(key));
    }
    public void addFiche(){
        System.out.println("Ajout d une fichier :");
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrer le nom du fiche :");
        String nomFiche=sc.nextLine();
        System.out.println("Entrer le numero du fiche :");
        String numeroFiche=sc.nextLine();
        System.out.println("Entrer le adresse du fiche :");
        String adresseFiche=sc.nextLine();
        this.map.put(nomFiche,new Fiche(nomFiche,numeroFiche,adresseFiche));
        System.out.println("Fiche ajouter avec succes");
    }
    public void afficheMap(Map<String,Fiche> map){
        System.out.println("Affiche de tous les fiches");
        Set<Map.Entry<String,Fiche>> set = map.entrySet();
        for(Map.Entry<String,Fiche> e:set){
            System.out.println("Key : "+e.getKey()+" Valeur : \n"+e.getValue());
        }
    }
}
