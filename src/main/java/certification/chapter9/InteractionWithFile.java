package certification.chapter9;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class InteractionWithFile {

    public static void main(String[] args) {

        // exists
        System.out.println(Files.exists(Paths.get("src/main/java/certification/chapter9/relationships.png")));
        System.out.println(Files.exists(Paths.get("/ostrich")));

        // isSameFile
        try {
            System.out.println(Files.isSameFile(
                    Paths.get("src/main/java/certification/chapter9/relationships.png"),
                    Paths.get("src/main/java/certification/chapter9/relationships.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // createDirectory/createDirectories
        try {
            Files.createDirectory(Paths.get("./directory1"));
            Files.createDirectories(Paths.get("./directory2/dir2/dr3"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // copy
        try {
            // options: NOFOLLOW_LINKS, REPLACE_EXISTING, and COPY_ATTRIBUTES
            Files.copy(Paths.get("./directory2"), Paths.get("./directory3"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("source-data.txt");
             OutputStream out = new FileOutputStream("output-data.txt")) {
            // Copy stream data to file
            Files.copy(is, Paths.get("wolf.txt"));
            // Copy file data to stream
            Files.copy(Paths.get("clown.txt"), out);
        } catch (IOException e){
            e.printStackTrace();
        }

        // move
        /*try {
            Files.move(Paths.get("c:\\zoo"), Paths.get("c:\\zoo-new"));
            Files.move(Paths.get("c:\\user\\addresses.txt"),
                    Paths.get("c:\\zoo-new\\addresses.txt"));
        } catch (IOException e) {
            // Handle file I/O exception...
        }*/

        // delete
        try {
//            Files.delete(Paths.get("./directory1"));
            Files.deleteIfExists(Paths.get("./directory1"));
            Files.deleteIfExists(Paths.get("wolf.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // charset
        /*Path path = Paths.get("/animals/gopher.txt");
        try (BufferedReader reader = Files.newBufferedReader(path,
                Charset.forName("UTF-8"))) {
            // Read from the stream
            String currentLine = null;
            while((currentLine = reader.readLine()) != null)
                System.out.println(currentLine);
        } catch (IOException e) {
            // Handle file I/O exception...
        }*/

        // readAll files
        try {
            Path path11 = Paths.get(".gitignore");
            final List<String> lines = Files.readAllLines(path11);
            for(String line: lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    // can be update by fork/join framework
    public static boolean deleteRecursive(File path) throws FileNotFoundException{
        if (!path.exists()) throw new FileNotFoundException(path.getAbsolutePath());
        boolean ret = true;
        if (path.isDirectory()){
            for (File f : path.listFiles()){
                ret = ret && InteractionWithFile.deleteRecursive(f);
            }
        }
        return ret && path.delete();
    }
}
