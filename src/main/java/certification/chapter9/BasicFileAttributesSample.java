package certification.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class BasicFileAttributesSample {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("pom.xml");
        BasicFileAttributes data1 = Files.readAttributes(path1, BasicFileAttributes.class);

        System.out.println("Is path a directory? " + data1.isDirectory());
        System.out.println("Is path a regular file? " + data1.isRegularFile());
        System.out.println("Is path a symbolic link? " + data1.isSymbolicLink());
        System.out.println("Path not a file, directory, nor symbolic link? " + data1.isOther());
        System.out.println("Size (in bytes): " + data1.size());
        System.out.println("Creation date/time: " + data1.creationTime());
        System.out.println("Last modified date/time: " + data1.lastModifiedTime());
        System.out.println("Last accessed date/time: " + data1.lastAccessTime());
        System.out.println("Unique file identifier (if available): " + data1.fileKey());

        // BasicFileAttributeView
        Path path2 = Paths.get("animal.data");
        BasicFileAttributeView view = Files.getFileAttributeView(path2, BasicFileAttributeView.class);
        BasicFileAttributes data2 = view.readAttributes();
        FileTime lastModifiedTime = FileTime.fromMillis(data2.lastModifiedTime().toMillis() + 10_000);
        view.setTimes(lastModifiedTime, null, null);
    }
}
