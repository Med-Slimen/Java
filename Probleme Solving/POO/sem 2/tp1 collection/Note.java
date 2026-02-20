public class Note implements Comparable<Note> {
    String cour;
    double note;
    public Note(String cour, double note) {
        this.cour = cour;
        this.note = note;
    }
    @Override
    public int compareTo(Note n) {
        if(this.note>n.note){
            return 1;
        }
        else if(this.note<n.note){
            return -1;
        }
        return 0;
    }

}
