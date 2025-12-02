import java.time.LocalDate;

public class BiiletTaggable extends Billet implements Taggable {
    protected String[] LTags;
    protected int nbTags;
    public BiiletTaggable(LocalDate datePub, String auteur,int capacite) {
        super(datePub, auteur);
        this.LTags = new String[capacite];
    }
    @Override
    public String toString() {
        String msg="";
        for(String s:LTags){
            msg+=s+" | ";
        }
        return super.toString()+" Les Tags : "+msg+ " Nombre des tags : "+nbTags;
    }

    @Override
    public void ajoutTag(String tag) {
        LTags[nbTags] = tag;
        nbTags++;
    }

    @Override
    public void supprimeTag(String tag) {
        if(rechercheTag(tag)==-1){
            System.out.println("Les Tags n'existe pas");
        }
        else{
            int i=rechercheTag(tag);
            if(LTags[nbTags-1].equals(tag)){
                LTags[nbTags-1]=null;
                this.nbTags--;
            }
            else{
                for(int j=i;j<nbTags-1;j++){
                    LTags[j]=LTags[j+1];
                }
                this.nbTags--;
                System.out.println("Le Tag :"+tag+" est supprimé");
            }
        }
    }

    @Override
    public int nombreTags() {
        return nbTags;
    }

    @Override
    public int rechercheTag(String tag) {
        int i=0;
        while(i<nbTags && !LTags[i].equals(tag)){
            i++;
        }
        if(i==nbTags){
            return -1;
        }
        else{
            return i;
        }
    }
}
