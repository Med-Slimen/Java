import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class StudentGroup {
    HashSet<Student> set;
    String id;
    public StudentGroup(String id) {
        this.id = id;
        set = new HashSet<Student>() ;
    }
    public HashSet<Student> getSet() {
        return set;
    }
    public String getId() {
        return id;
    }
    public void addStudent(Student st){
        set.add(st);
    }
    public void affiche(){
        System.out.println("ID : "+id);
        System.out.println("List d etudiant");
        for(Student s: set){
            System.out.println(s);
        }
    }
    public void sort(){
        ArrayList<Student> list = new ArrayList<>(this.set);
        Collections.sort(list);
        for(Student s: list){
            System.out.println(s);
        }
    }
}
