package certification.datetime.legacy;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Serhii K. on 12.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        // Old to new
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        // New to old
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date dateFromOld = Date.from(instant);
    }
}
