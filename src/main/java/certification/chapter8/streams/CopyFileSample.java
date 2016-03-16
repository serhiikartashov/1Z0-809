package certification.chapter8.streams;

import java.io.*;

/**
 * Created by Serhii K. on 3/14/2016.
 */
public class CopyFileSample {

    // with using FileInputStream only!
    public static void copyFS(File source, File destination) throws IOException {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(destination)) {
            int b;
            // by bite
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }

    public static void copyBFS(File source, File destination) throws IOException {
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
            /*
            a buffer size of 1024 in this example, as this is appropriate for a wide variety of
            circumstances, although in practice you may see better performance with a larger or smaller
            buffer size. This would depend on a number of factors including file system block size and CPU
            hardware.
            */
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("src/main/java/certification/chapter8/streams/CopyFileSample.java");
        File destination = new File("Destination.java");
        copyFS(source, destination);
        copyBFS(source, destination);
    }
}
