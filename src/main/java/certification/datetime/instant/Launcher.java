package certification.datetime.instant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * Created by Serhii K. on 12.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        // Instant is useful for generating a datetime stamp to represent machine datetime.
        Instant timestamp = Instant.now();
        // Gets the number of seconds from the Java epoch of 1970-01-01T00:00:00Z.
        System.out.println("timestamp: " + timestamp.getEpochSecond());     // timestamp: 1444654450

        // How many seconds have occurred since the beginning of the Java epoch.
        long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.SECONDS);
        System.out.println("Amount of seconds from java epoch: " + secondsFromEpoch);   // 1444654450
        long minutesFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.MINUTES);
        System.out.println("Amount of minutes from java epoch: " + minutesFromEpoch);   // 24077574

        // Convert "machine datetime" to human units
        LocalDateTime humanTime = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        // different methods to operate datetime!
        // toString the same
        System.out.println("timestamp: " + timestamp);      // 2015-10-12T12:54:10.787Z
        System.out.println("humanTime: " + humanTime);      // 2015-10-12T13:54:10.787Z

    }

}
