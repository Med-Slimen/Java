public class ResultatRang implements Resultat{
    private int rang;
    public ResultatRang(int rang){
        this.rang=rang;
    }
    @Override
    public String toString(){
        return "Resultat rang: "+rang;
    }
    @Override
    public void affiche() {
        System.out.println(toString());
    }

    @Override
    public int compareTo(Resultat r) throws IllegalArgumentException {
        if (r instanceof ResultatRang) {
            if (this.rang<((ResultatRang) r).rang) {
                return 1;
            }
            else if (this.rang>((ResultatRang) r).rang) {
                return -1;
            }
            else{
                return 0;
            }
        }
        else{
            throw new IllegalArgumentException("Le resultat n est pas de meme type");
        }
    }
}
