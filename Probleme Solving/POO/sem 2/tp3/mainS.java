public class mainS {
    public static void main(String[] args) {
        StudentGroup sg=new StudentGroup("SG1");
        Curriculum curr=new Curriculum("Curr 1");
        curr.addModCoef("POOA",3);
        curr.addModCoef("DEVWEB",2);
        Student s1=new Student("S1",curr);
        s1.addNote("POOA",2.0);
        s1.addNote("POOA",1.0);
        s1.addNote("POOA",1.0);
        s1.addNote("DEVWEB",2.0);
        s1.addNote("DEVWEB",1.0);
        s1.addNote("DEVWEB",1.0);
        sg.addStudent(s1);
        Student s2=new Student("S2",curr);
        s2.addNote("POOA",10.0);
        s2.addNote("POOA",10.0);
        s2.addNote("POOA",6.0);
        s2.addNote("DEVWEB",14.0);
        s2.addNote("DEVWEB",19.0);
        s2.addNote("DEVWEB",11.0);
        sg.addStudent(s2);
        sg.affiche();
        System.out.println("--- Aprés le trie par moyenne :");
        sg.sort();
    }
}
