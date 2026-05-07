import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.stream.Stream;

public class MainF {
    public static void main(String[] args) throws IOException {
        System.out.println("En utlisiant IO...............................................");
        System.out.println("Répertoire courant : "+System.getProperty("user.dir"));
        File rep = new File(".");
        System.out.println("Chemin relatif : "+ rep.getPath());// à compléter
                System.out.println("Chemin absolu : "+rep.getAbsolutePath() );// à compléter
        for (File element:File.listRoots()) {
                System.out.println("Racine : "+element);
        }
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
        /* en utlilisant nio */
        System.out.println("En utlisiant NIO...............................................");
        System.out.println("Répertoire courant : "+System.getProperty("user.dir"));
        Path p=Path.of(".");
        System.out.println("Chemin relatif : "+p);
        System.out.println("Chemin absolu : "+p.toAbsolutePath() );
        for (File element:File.listRoots()) {
            System.out.println("Racine : "+element);
        }
        System.out.println("liste de tous les repertoires.......................................................");
        try(Stream<Path> streams1=Files.list(p);Stream<Path> streams2=Files.list(p);Stream<Path> streams3=Files.list(p)){
            streams1.forEach(stream->{
                if(Files.isDirectory(stream)){
                    System.out.println(stream.getFileName()+"\t");
                    if(stream.toFile().getName().length()<8){
                        System.out.print("\t");
                        System.out.println("<REP>");
                    }
                }
            });
            streams2.forEach(stream->{
                if(Files.isRegularFile(stream)){
                    System.out.print(stream.toFile().getName()+"\t");
                    if (stream.toFile().getName().length()<8) System.out.print("\t");
                    System.out.printf("%tc", new Date(stream.toFile().lastModified()));
                    System.out.printf("\t%10d octets\n", stream.toFile().length());
                }
            });
            System.out.println("liste des repertoire qui commencent par la lettre b..................................");
            streams3.forEach(stream->{
                if(Files.isDirectory(stream)){
                    if(filter.accept(stream.toFile(),stream.toFile().getName())){
                    System.out.println(stream.getFileName()+"\t");
                    if(stream.toFile().getName().length()<8){
                        System.out.print("\t");
                        System.out.println("<REP>");
                    }
                }
            }});
        }
        catch (IOException e){
            e.printStackTrace();
        }


}

}
