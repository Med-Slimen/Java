import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student> {
    private String id;
    private Curriculum myCurriculum;
    private HashMap<String, ArrayList<Double>> resultats=new HashMap<>();
    public Student(String i, Curriculum c) {
        id=i;
        this.myCurriculum=c;
        Set<String> set=this.myCurriculum.getModSet();
        for(String s: set){
            this.resultats.put(s,new ArrayList<>());
        }
    }
public String toString() {

    return "Student [id=" + id + ", myCurriculum=" + myCurriculum

            + ", resultats=" + resultats + "]"+ "Moyenne Generale : "+average();

}
public String getId() {
    return this.id;
}
public Curriculum getMyCurriculum() {
    return myCurriculum;
}
public void addNote(String s, Double d){
        this.resultats.get(s).add(d);
}
public double average(String s){
        double sum=0;
        ArrayList<Double> d = this.resultats.get(s);
        for(int i=0;i<d.size();i++){
            sum+=d.get(i);
        }
        return sum/d.size();
}
public double average(){
        Set<String> s=this.resultats.keySet();
        double sum=0;
        int sumCoef=0;
        for(String key:s){
            sum+=average(key)*this.myCurriculum.getMod_Coef().get(key);
            sumCoef+=this.myCurriculum.getCoefMod(key);
        }
        return sum/sumCoef;
}
public int compareTo(Student st){
        if(this.average()<st.average()){
            return -1;
        }
        else if(this.average()>st.average()){
            return 1;
        }
        return 0;
}
}
