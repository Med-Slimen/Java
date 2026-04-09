import java.util.*;

public class ReseauSocial {
    HashMap<Personne, ArrayList<Personne>> reseau ;
    // pour chaque personne on associe une liste de suiveurs
    public ReseauSocial() {
        reseau = new HashMap <Personne, ArrayList<Personne>>() ;
    }
    public void ajouterUtilisateur(Personne p){
        if(reseau.containsKey(p)){
            System.out.println("User already exist");
            return;
        }
        reseau.put(p,new ArrayList<>());
    }
    public void AjouterSuiveur(Personne p , Personne p1){
        if(!reseau.containsKey(p)){
            ajouterUtilisateur(p);
        }
        else if(reseau.get(p).contains(p1)){
            System.out.println("Follower Already exist");
            return;
        }
        reseau.get(p).add(p1);
    }
    public HashSet<Personne> ListeUtilisateursSuivis(){
        return new HashSet<>(reseau.keySet());
    }
    public HashSet<Personne> ListeUtilisateursSuiveurs(){
        HashSet<Personne> us=new HashSet<>();
        for(ArrayList<Personne> list:reseau.values()){
            us.addAll(list);
        }
        return us;
    }
    public void TrierListeSuiveurs(){
        HashSet<Personne> us=new HashSet<>(ListeUtilisateursSuiveurs());
        /* Comparable */
        TreeSet<Personne> ts=new TreeSet<>(us);
        /* En utilisant comparator TreeSet<Personne> ts=new TreeSet<>((p1,p2)->p1.getPseudo().compareTo(p2.getPseudo()));
        ts.addAll(us);*/
        for(Personne p:ts){
            System.out.println(p);
        }
    }
    public void affiche(){
        Set<Map.Entry<Personne,ArrayList<Personne>>> s=reseau.entrySet();
        Iterator<Map.Entry<Personne,ArrayList<Personne>>> it=s.iterator();
        while(it.hasNext()){
            Map.Entry<Personne,ArrayList<Personne>> sm=it.next();
            System.out.println(sm.getKey() + " : "+sm.getValue());
        }
    }
    public Personne MaxSuiveurs(){
        int max=Integer.MIN_VALUE;
        Personne pp=null;
        for(Personne p:reseau.keySet()){
            if(reseau.get(p).size() > max){
                max=reseau.get(p).size();
                pp=p;
            }
        }
        return pp;
    }
}
