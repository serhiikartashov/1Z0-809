package certification.datetime.clock;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

/**
 * Created by Serhii K. on 13.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {

        System.out.println(Clock.systemDefaultZone());      // SystemClock[Europe/Helsinki]

        // Current Time
        Clock clock = Clock.systemUTC();
        System.out.println(clock);                          // SystemClock[Z]
        Clock clock1 = Clock.offset(clock, Duration.ofSeconds(10));
        System.out.println(clock1);                         // OffsetClock[SystemClock[Z],PT10S]
        Clock clock2 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Tokyo"));
        System.out.println(clock2);                         // FixedClock[2015-10-13T13:25:20.636Z,Asia/Tokyo]
    }



}
