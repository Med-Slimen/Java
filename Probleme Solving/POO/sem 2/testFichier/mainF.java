import java.io.*;
import java.nio.file.StandardOpenOption;

public class mainF {
    public static void main(String[] args){
        System.out.println("HI");
        String source="C:\\Users\\LENOVO\\Desktop\\Prog\\Java\\Probleme Solving\\POO\\sem 2\\testFichier\\reader.txt";
        String copy="C:\\Users\\LENOVO\\Pictures\\Camera Roll\\writer.txt";
        try(BufferedReader fr=new BufferedReader(new FileReader(source));
            FileWriter fw=new FileWriter(copy)
        ) {
            fw.write(fr.readAllAsString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
