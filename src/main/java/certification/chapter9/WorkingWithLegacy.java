package certification.chapter9;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Serhii K. on 3/17/2016.
 */
public class WorkingWithLegacy {

    public static void main(String[] args) {
        File file1 = new File("pandas/cuddly.png");
        Path path1 = file1.toPath();

        Path path2 = Paths.get("cuddly.png");
        File file2 = path2.toFile();
    }
}
