package certification.chapter9;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class FileAttributes {

    public static void main(String[] args) {
        Files.isDirectory(Paths.get("/canine/coyote/fur.jpg"));
        Files.isRegularFile(Paths.get("/canine/types.txt"));
        Files.isSymbolicLink(Paths.get("/canine/coyote"));

        try {
            System.out.println(Files.isHidden(Paths.get("/walrus.txt")));
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        System.out.println(Files.isReadable(Paths.get("/seal/baby.png")));
        System.out.println(Files.isExecutable(Paths.get("/seal/baby.png")));

        try {
            // return value in bytes! for files only
            System.out.println(Files.size(Paths.get("/zoo/c/animals.txt")));
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        try {
            final Path path = Paths.get("zoo.log");
            System.out.println(Files.getLastModifiedTime(path).toMillis());
            Files.setLastModifiedTime(path,
                    FileTime.fromMillis(System.currentTimeMillis()));
            System.out.println(Files.getLastModifiedTime(path).toMillis());
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        try {
            // Read owner of file
            Path path = Paths.get("zoo.log");
            System.out.println(Files.getOwner(path).getName());
            // Change owner of file
            // with throw java.nio.file.attribute.UserPrincipalNotFoundException if not found user
            UserPrincipal owner = path.getFileSystem()
                    .getUserPrincipalLookupService().lookupPrincipalByName("SKARTASHOV");
            // Files.setOwner(path, owner); // java.nio.file.AccessDeniedException: zoo.log ; system prevent this action
            // Output the updated owner information
            System.out.println(Files.getOwner(path).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
