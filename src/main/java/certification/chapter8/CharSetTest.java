package certification.chapter8;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Created by Serhii K. on 3/14/2016.
 */
public class CharSetTest {

    public static void main(String[] args) {
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.setProperty("file.encoding", "Latin-1");
        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("Default Charset in Use=" + getDefaultCharSet());
    }

    private static String getDefaultCharSet() {
        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        return writer.getEncoding();
    }
}
