public class Periodique extends Documents {
    protected int freqPar;
    public Periodique(int freqPar,String titre, int numId, int nbPages) {
        super(titre, numId, nbPages);
        this.freqPar = freqPar;
    }
    public void edition(){
        System.out.println("Type : "+getType()+" , Titre : "+getTitre()+" numId : "+getNumId()+" nbPages : "+getNbPages()+", freqPar : "+getFreqPar());
    }
    public int getFreqPar() {
        return freqPar;
    }
    public String getType(){
        return "Periodique";
    }
}
