package certification.chapter9;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class TestClass {

    public static void main(String[] args) throws URISyntaxException {
        Path path11 = Paths.get("pandas/cuddly.png");
        Path path21 = Paths.get("c:\\zooinfo\\November\\employees.txt");
        Path path31 = Paths.get("/home/zoodirector");

        // insert path separator automatically
        Path path12 = Paths.get("pandas","cuddly.png");
        Path path22 = Paths.get("c:","zooinfo","November","employees.txt");
        Path path32 = Paths.get("/","home","zoodirector");

        Path path1 = Paths.get(new URI("file://pandas/cuddly.png"));    // THROWS EXCEPTION
                                                                        // AT RUNTIME
        Path path2 = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));
        Path path3 = Paths.get(new URI("file:///home/zoodirectory"));

        Path path4 = Paths.get(new URI("http://www.wiley.com"));
        Path path5 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));

        // using FileSystems
        Path path13 = FileSystems.getDefault().getPath("pandas/cuddly.png");
        Path path23 = FileSystems.getDefault().getPath("c:","zooinfo","November","employees.txt");
        Path path33 = FileSystems.getDefault().getPath("/home/zoodirector");

        FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
        Path path = fileSystem.getPath("duck.txt");
    }
}
