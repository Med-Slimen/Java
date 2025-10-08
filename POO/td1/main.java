public class main {
    public static void main(String args[]){
        Dictionnaire Dict1=new Dictionnaire("Dict 1");
        Mot_dict mot1=new Mot_dict("tab","tab");
        Mot_dict mot2=new Mot_dict("tableaux","tab");
        Mot_dict mot3=new Mot_dict("arabic","arabya");
        Mot_dict mot4=new Mot_dict("tableaux1","tab");
        Dict1.Ajouter_Mot(mot1);
        Dict1.Ajouter_Mot(mot2);
        Dict1.Ajouter_Mot(mot3);
        Dict1.Ajouter_Mot(mot4);
        System.out.println("Dcitionnaire : "+Dict1.getNom()+"\n"+Dict1);
        System.out.println("le nombre de synonyme du mot tab "+Dict1.Nombre_synonyme(mot1));
        System.out.println("Recherche du definition du arabic :  "+ Dict1.Recherche_dicho("arabic"));
        System.out.println("aprés supression du mot arabic");
        Dict1.Supprimer_Mot(mot3);
        System.out.println(Dict1);
        
    }
}
