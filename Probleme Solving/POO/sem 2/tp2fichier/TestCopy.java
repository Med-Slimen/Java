import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TestCopy {
    public static void main(String[] args) throws IOException {
        /* Exercice 1

        File inputFile=new File("C:\\Users\\LENOVO\\Desktop\\Prog\\Java\\Probleme Solving\\POO\\sem 2\\tp2fichier\\in.txt");
        File outputFile=new File("C:\\Users\\LENOVO\\Desktop\\Prog\\Java\\Probleme Solving\\POO\\sem 2\\tp2fichier\\out.txt");
        FileReader in=new FileReader(inputFile);
        FileWriter out=new FileWriter(outputFile);
        int c;
        while ((c=in.read())!=-1){
            out.write(c);
        }
        in.close();
        out.close();*/
        /* En utilisant NIO */
        Path iF=Path.of("C:\\Users\\LENOVO\\Desktop\\Prog\\Java\\Probleme Solving\\POO\\sem 2\\tp2fichier\\in.txt");
        Path oF=Path.of("C:\\Users\\LENOVO\\Desktop\\Prog\\Java\\Probleme Solving\\POO\\sem 2\\tp2fichier\\out.txt");
        String lines=Files.readString(iF);
        Files.writeString(oF,lines);
        /* Exercice 2
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le login");
        String loginU=sc.nextLine();
        System.out.println("Donner le mot de passe");
        String passwordU=sc.nextLine();

        try(BufferedReader br=new BufferedReader(new FileReader("C:\\\\Users\\\\LENOVO\\\\Desktop\\\\Prog\\\\Java\\\\Probleme Solving\\\\POO\\\\sem 2\\\\tp2fichier\\\\in.txt"));){
            String line;
            boolean a=false;
            while((line=br.readLine()) != null){
                String[] auth=line.split(" ");
                if(auth[0].equals(loginU) && auth[1].equals(passwordU)){
                    a=true;
                    break;
                }
            }
            br.close();
            if(a) System.out.println("Authentification Reussi");
            else System.out.println("PB Authentification");
        }
        catch (Exception e){
            System.out.println(e);
        }*/
        /* En utilisant NIO */
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le login");
        String loginU=sc.nextLine();
        System.out.println("Donner le mot de passe");
        String passwordU=sc.nextLine();
        List<String> liste=Files.readAllLines(iF);
        System.out.println(liste);
        boolean a=false;
        for(String line:liste){
            String[] l=line.split(" ");
            if(loginU.equals(l[0]) &&  passwordU.equals(l[1])){
                a=true;
                break;
            }
        }
        if(a)System.out.println("Authentification Reussi");
        else System.out.println("PB Authentification");

    }
}
