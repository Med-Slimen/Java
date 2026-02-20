import java.util.*;
import java.util.Collection;

public class DossierPharmacie {
    private String nom;
    private HashMap<String,Patient> map = new HashMap<>();
    public DossierPharmacie(String nom){
        this.nom=nom;
    }
    public void nouveauPatient (String nom,String []ord){
        this.map.put(nom,new Patient(nom));
        Patient patient = this.map.get(nom);
        for (String s : ord) {
            patient.ajouterMedicament(s);
        }
    }
    public boolean ajoutMedicament(String nom,String m){
        if(this.map.containsKey(nom)){
            this.map.get(nom).ajouterMedicament(m);
            return true;
        }
        return false;
    }
    public void affichePatient (String nom){
        this.map.get(nom).affiche();
    }
    public void affiche (){
        System.out.println("Nom Pharamacie : "+this.nom);
        Set<Map.Entry<String,Patient>> m=this.map.entrySet();
        for(Map.Entry<String,Patient> k:m){
            k.getValue().affiche();
        }
    }
    public Collection<String> affichePatientAvecMedicament (String m){
        Collection<String> list=new ArrayList<>();
        for(Patient p:this.map.values()){
            if(p.ordonnance.contains(m)){
                list.add(p.getNom());
            }
        }
        return list;
    }

}
