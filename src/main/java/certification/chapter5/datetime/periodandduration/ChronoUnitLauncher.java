package certification.chapter5.datetime.periodandduration;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * Created by Serhii K. on 12.10.2015.
 */
public class ChronoUnitLauncher {

    public static void main(String[] args) {

        // units
        Instant.now().plus(1, ChronoUnit.DAYS);         // Unit that represents the concept of a day.

        System.out.println(ChronoUnit.DAYS);            // Days
        System.out.println(Arrays.asList(ChronoUnit.values()));
        // [Nanos, Micros, Millis, Seconds, Minutes, Hours, HalfDays,
        // Days, Weeks, Months, Years, Decades, Centuries, Millennia, Eras, Forever]

        Instant previous = Instant.ofEpochSecond(54545454);
        Instant current = Instant.now();

        long gap = ChronoUnit.MILLIS.between(previous, current);
        Duration duration = ChronoUnit.MILLIS.getDuration();
        System.out.println(gap);            // 1390181631925
        System.out.println(duration);       // PT0.001S

    }
}
