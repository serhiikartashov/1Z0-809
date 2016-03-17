package certification.chapter9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class InteractionWithPath {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java");
        System.out.println("The Path Name is: "+path);
        for(int i=0; i<path.getNameCount(); i++) {
            System.out.println(" Element "+i+" is: "+path.getName(i));
        }
        Path absolutePath = path.toAbsolutePath();
        System.out.println("The Path Name is: "+ absolutePath);
        for(int i=0; i<absolutePath.getNameCount(); i++) {
            System.out.println(" Element "+i+" is: "+absolutePath.getName(i));
        }

        printPathInformation(Paths.get("src/main/java/certification/chapter9/relationships.png"));

        printPathInformation(Paths.get("src/main/java/certification/chapter9/relationships.png").toAbsolutePath());


        Path path1 = Paths.get("F:\\Dropbox\\projects\\JAVA_CERTIFICATIONS\\1Z0-809\\src\\main\\java");
        System.out.println("Path1 is Absolute? "+path1.isAbsolute());
        System.out.println("Absolute Path1: "+path1.toAbsolutePath());

        Path path2 = Paths.get("src\\main\\java");
        System.out.println("Path1 is Absolute? "+path2.isAbsolute());
        System.out.println("Absolute Path1: "+path2.toAbsolutePath());

        // subpath
        Path path3 = Paths.get("/mammal/carnivore/raccoon.image");
        System.out.println("Path is: "+path3);
        System.out.println("Subpath from 0 to 3 is: "+path3.subpath(0,3));
        System.out.println("Subpath from 1 to 3 is: "+path3.subpath(1,3));
        System.out.println("Subpath from 1 to 2 is: "+path3.subpath(1,2));
        //System.out.println("Subpath from 0 to 4 is: "+path.subpath(0,4)); // THROWS EXCEPTION AT RUNTIME

        // relative path
        Path path4 = Paths.get("E:\\habitat");
        Path path5 = Paths.get("E:\\sanctuary\\raven");
        System.out.println(path4.relativize(path5));
        System.out.println(path5.relativize(path4));

        // requires absolute path
        /*Path path1 = Paths.get("/primate/chimpanzee");
        Path path2 = Paths.get("bananas.txt");
        Path1.relativize(path3); // THROWS EXCEPTION AT RUNTIME*/

        // requires the same root
        /*Path path3 = Paths.get("c:\\primate\\chimpanzee");
        Path path4 = Paths.get("d:\\storage\\bananas.txt");
        path3.relativize(path4); // THROWS EXCEPTION AT RUNTIME*/

        // resolve
        final Path path6 = Paths.get("/cats/../panther");
        final Path path7 = Paths.get("food");
        System.out.println(path6.resolve(path7)); // \cats\..\panther\food

        final Path path8 = Paths.get("/turkey/food");
        final Path path9 = Paths.get("/tiger/cage");
        // using roots will take last one
        System.out.println(path8.resolve(path9)); // \tiger\cage

        // relative
        Path path10 = Paths.get("E:\\data");
        Path path11 = Paths.get("E:\\user\\home");
        Path relativePath = path10.relativize(path11);
        System.out.println(path10.resolve(relativePath)); //

        System.out.println(path10.resolve(relativePath).normalize()); //

        // for symbolic link: /zebra/food.source ⃗ /horse/food.txt
        try {
            System.out.println(Paths.get("/zebra/food.source").toRealPath());   // /horse/food.txt
            System.out.println(Paths.get(".././food.txt").toRealPath());        // /horse/food.txt
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        System.out.println(Paths.get(".").toRealPath());
        System.out.println(Paths.get("..").toRealPath());
        System.out.println(Paths.get("../..").toRealPath());

    }

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: "+path.getFileName());
        System.out.println("Root is: "+path.getRoot());
        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null) {
            System.out.println(" Current parent is: "+currentParent);
        }
    }
}
