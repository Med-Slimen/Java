public class Blog {
    private String titre;
    private Publiable[] LBillets;
    private int nbBillets;
    public Blog(String titre,int capacite){
        this.titre=titre;
        this.nbBillets=0;
        this.LBillets=new Publiable[capacite];
    }
    public void post(Publiable billet) throws InvalidURLException{
        if(billet instanceof Video){
            Video video=(Video)billet;
            if(video.getUrl().startsWith("https")){
                this.LBillets[nbBillets++]=billet;
            }
            else{
                throw new InvalidURLException("L url n est pas securisé");
            }

        }
        else{
            this.LBillets[nbBillets++]=billet;
        }
    }
    public int getNombreBilletsTaggables(){
        int s=0;
        for(int i=0;i<nbBillets;i++){
            if (LBillets[i] instanceof BiiletTaggable){
                s++;
            }
        }
        return s;
    }
    public Publiable[] RechercheBilletsTaggablesParAuteur(String auteur){
        Publiable[] p=new Publiable[10];
        int j=-1;
        for (int i=0;i<nbBillets;i++){
            if (LBillets[i] instanceof BiiletTaggable && LBillets[i].getAuteur().equals(auteur)){
                j++;
                p[j]=LBillets[i];
            }
        }
        return p;
    }
    public Publiable getPlusRecentBillet(){
        Publiable p;
        Publiable b=LBillets[0];
        for (int i=1;i<nbBillets;i++){
            if(LBillets[i].getDatePublication().isAfter(b.getDatePublication())){
                b=LBillets[i];
            }
        }
        return b;
    }
    public Publiable[] RechercheBilletsParContenu(String[] mots){
        Publiable[] p=new Publiable[10];
        int j=-1;
        for(int i=0;i<nbBillets;i++){
            if (LBillets[i] instanceof Message){
                boolean b=true;
                String msg=((Message)LBillets[i]).getMessage();
                for (String mot : mots) {
                    if (msg.indexOf(mot) == -1) {
                        b = false;
                        break;
                    }
                }
                if(b){
                    j++;
                    p[j]=LBillets[i];
                }
            }
        }
        return p;
    }
}
