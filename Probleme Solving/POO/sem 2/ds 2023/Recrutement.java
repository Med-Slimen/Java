import java.util.*;
public class Recrutement {
    private String nomdelacompagnie;
    private Set<Integer> jobs;
    private Map<Integer, Set<Candidat>> candidatures;
    public Recrutement(String nomdelacompagnie) {
        this.nomdelacompagnie = nomdelacompagnie;
        this.jobs= new HashSet<Integer>();
        this.candidatures = new HashMap<Integer, Set<Candidat>>();
    }
    public void ajoutOffre(int jobid) {
        if (jobs.contains(jobid))
            System.out.println("L'ID du job existe déjà !");
        else { jobs.add(jobid);
            candidatures.put(jobid, new HashSet<Candidat>()); } }
    public void postuler(int jobid, Candidat c) {
        if(!this.jobs.contains(jobid)){
            System.out.println("Le job n exsite pas !");
        }
        else if(! this.candidatures.containsKey(jobid)){
            this.candidatures.put(jobid,new HashSet<>());
        }
        else{
            this.candidatures.get(jobid).add(c);
        }
    }
    public ArrayList<Candidat> trierCandidatsParExperience(int jobid) {
        ArrayList<Candidat> cc=new ArrayList<>(this.candidatures.get(jobid));
        Collections.sort(cc,(c1,c2)->Integer.compare(c1.getAnneesExperience(),c2.getAnneesExperience()));
        return cc;
    }
    public void SelectionCandidat(int jobid, String nomCompetence) {
        int nb=0;
        int max=Integer.MIN_VALUE;
        String nom="";
        for(Candidat c:this.candidatures.get(jobid)){
            for(Competence cc:c.getComp()){
                if(cc.getNom().equals(nomCompetence)){
                    nb++;
                    if(cc.getScore()>max){
                        max=cc.getScore();
                        nom=c.getNom();
                    }
                }
            }
        }
        System.out.println("Le nombre de candidats : "+nb+ " \n" +
                " nom du candidat qui a la meuilleur score en "+nomCompetence+" est : "+nom+" avec un score de : "+max);
    }
}