package certification.chapter9;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class StreamMethods {

    public static void main(String[] args) {
        Path path = Paths.get("./src");
        try {
            Files.walk(path)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // old implementation from Java 7
        // see SimpleFileVisitor http://goo.gl/2d4noL
        try {
            List<Path> result = directoryStream(path);
            for (Path path1 : result) {
                System.out.println(path1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // traverse symbolic links: may be circular dependency!
            Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("                                            \n");

        Path path2 = Paths.get("./src");
        long dateFilter = 1420070400000l;
        try {
            Stream<Path> stream = Files.find(
                    path2,
                    10,
                    (p, a) -> p.toString().endsWith(".png")
                            && a.lastModifiedTime().toMillis() > dateFilter);
            stream.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Path path3 = Paths.get("src/main/java/certification/chapter9");
            Files.list(path3)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toAbsolutePath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path4 = Paths.get("pom.xml");
        try {
            Files.lines(path4).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path5 = Paths.get("stream.log");
        try {
            System.out.println(Files.lines(path5)
                    .filter(s -> s.startsWith("WARN "))
                    .map(s -> s.substring(5))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<Path> directoryStream(Path path) throws IOException {
        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.md")) {
            for (Path entry : stream) {
                result.add(entry);
            }
        } catch (DirectoryIteratorException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
