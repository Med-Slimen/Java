import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MainF {
    public static void main(String[] args) throws IOException {
        System.out.println("Répertoire courant : "+System.getProperty("user.dir"));
        File rep = new File(".");
        System.out.println("Chemin relatif : "+ rep.getPath());// à compléter
                System.out.println("Chemin absolu : "+rep.getAbsolutePath() );// à compléter

        for (File element:File.listRoots()) {
                System.out.println("Racine : "+element);}
        System.out.println("liste de tous les repertoires.......................................................");
        for (File element: rep.listFiles()){
        if (element.isDirectory()) {
            System.out.print(element.getName()+"\t");
        if (element.getName().length()<8){
        System.out.print("\t");
        System.out.println("<REP>");
    }}}
for (File element : rep.listFiles())
            if (element.isFile()){
        System.out.print(element.getName()+"\t");
        if (element.getName().length()<8) System.out.print("\t");
        System.out.printf("%tc", new Date(element.lastModified()));
        System.out.printf("\t%10d octets\n", element.length());
    }
    System.out.println("liste des repertoire qui commencent par la lettre b..................................");
        FilenameFilter filter = new FilenameFilter('b');
        for (File element: rep.listFiles()){
            if (element.isDirectory()) {
                if(filter.accept(element, element.getName())){
                System.out.print(element.getName()+"\t");
                if (element.getName().length()<8){
                    System.out.print("\t");
                    System.out.println("<REP>");
                }
                }
            }
        }
}

}
