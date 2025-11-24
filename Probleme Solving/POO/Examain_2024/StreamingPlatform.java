public class StreamingPlatform {
    public User[] tabU;
    private Content[] tabC;
    private int nbrU=0;
    private int nbrC=0;
    private int capU;
    private int capC;
    public StreamingPlatform(int capU, int capC){
        this.capU = capU;
        this.capC = capC;
        tabU = new User[capU];
        tabC = new Content[capC];
    }
    public void afficheTabC(){
        for(int i=0;i<nbrC;i++){
            System.out.println(i+","+tabC[i]);
        }
    }
    public void afficheTabU(){
        for(int i=0;i<nbrU;i++){
            System.out.println(i+","+tabU[i]);
        }
    }
    public void addContent(Content content){
        if (nbrC<capC){
            tabC[nbrC]=content;
            nbrC++;
        }
        else{
            System.out.print("Taille maximale attenit pour le tableaux du contenue !");
        }
    }
    public void addUser(User user){
        if (nbrU<capU){
            tabU[nbrU]=user;
            nbrU++;
        }
        else{
            System.out.print("Taille maximale attenit pour le tableaux du utitlisateur !");
        }
    }
    public Content findContent(String title){
        for (int i = 0; i<nbrC; i++){
            if (tabC[i].title.equals(title)){
                return tabC[i];
            }
        }
        return null;
    }
    public void playContent(User user, String title) throws AccessDeniedException{
        Content c=findContent(title);
        if (c!=null){
            if (user.canPlay(c)){
                c.play();
                user.addWatchedContent(c);
            }
            else{
                throw new AccessDeniedException("l utilisateur "+user.getNom()+" n a pas l access a "+c.title);
            }
        }
        else{
            System.out.println("Un content de ce titre n existe pas");
        }
    }
    public boolean exist(Content c,Content[] tabG){
        for (int i = 0; i< tabG.length; i++){
            if (tabG[i]!=null && tabG[i].title.equals(c.title)){
                return true;
            }
        }
        return false;
    }
    public Content[] getRecommendations(User user){
        Content[] recommendations = new Content[10];
        int j=0;
        for(String s:user.getWatchedGenres()){
            for(Content c:tabC){
                if(c!=null && c.genre.equals(s) && !exist(c,user.getWatchedContent())){
                    recommendations[j]=c;
                    j++;
                }
            }
        }
        return recommendations;
    }

}
