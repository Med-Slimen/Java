public class SteamMain {
    public static void main(String[] args){
        StreamingPlatform str=new StreamingPlatform(10,10);
        Movie m=new Movie("Inception", "Sci-Fi", false, 148);
        Serie s=new Serie("Stranger Things", "Thriller", false, 25, 50);
        Serie s1=new Serie("Serie de type th", "Thriller", false, 25, 50);
        Movie m2=new Movie("Charlie Chaplin", "Comedy", true, 75);
        Serie s2=new Serie("Friends", "Comedy", true, 236, 22);
        User u1=new User("Imene",false);
        User u2=new User("jihene",true);
        str.addContent(m);
        str.addContent(s);
        str.addContent(m2);
        str.addContent(s1);
        str.addContent(s2);
        str.addUser(u1);
        str.addUser(u2);
        try{
            str.playContent(u1,"Inception");
        }
        catch (AccessDeniedException e){
            System.out.println(e.getMessage());
        }
        try{
            str.playContent(u2,"Stranger Things");
        }
        catch(AccessDeniedException e){
            System.out.println(e.getMessage());
        }
        try {
            str.playContent(u2,"Friends");
        }
        catch (AccessDeniedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Tableaux du content :");
        str.afficheTabC();
        System.out.println("Tableaux du users :");
        str.afficheTabU();
        System.out.println("Watched Content du user jihene:");
        Content[] wc=str.tabU[1].getWatchedContent();
        for(Content c:wc){
            if (c!=null){
                System.out.println(c);
            }

        }
        Content[] c=str.getRecommendations(u2);
        System.out.println("Les recommendation du utlisateur "+u2.getNom());
        for(Content c1: c){
            if(c1!=null){
                System.out.println(c1);
            }
        }
    }
}
