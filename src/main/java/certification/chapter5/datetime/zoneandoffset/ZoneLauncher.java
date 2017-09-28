package certification.chapter5.datetime.zoneandoffset;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneRulesProvider;
import java.util.*;

import static java.lang.System.*;

public class ZoneLauncher {

    public static void main(String[] args) {
        printAllTimeZones();
        out.println(ZoneId.systemDefault());
        out.println(ZoneId.of("Asia/Tokyo"));
        out.println(ZoneId.of("UTC"));
        out.println();
        out.println(OffsetDateTime.now(ZoneId.of("UTC")));
        out.println(OffsetDateTime.now(ZoneId.of("Asia/Tokyo")));
        out.println(OffsetDateTime.now(ZoneId.systemDefault()));
        out.println();
        out.println(Timestamp.from(OffsetDateTime.now(ZoneId.of("UTC")).toInstant()));
        out.println(Timestamp.from(OffsetDateTime.now(ZoneId.of("Asia/Tokyo")).toInstant()));
        out.println(Timestamp.from(OffsetDateTime.now(ZoneId.systemDefault()).toInstant()));

        out.println(Timestamp.valueOf(OffsetDateTime.now().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));

//        zonedDateTime();

        ZoneRules kiev = ZoneRulesProvider.getRules("Europe/Kiev", false);
        out.println(kiev.getTransitionRules());

        // RESTRICTION: you cannot receive all zones by continents

        offsetDateTime();
    }

    private static void printAllTimeZones() {
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime dt = LocalDateTime.now();

        // Create a List using the set of zones and sort it.
        List<String> zoneList = new ArrayList<String>(allZones);
        //Collections.sort(zoneList);

        for (String s : zoneList) {
            ZoneId zone = ZoneId.of(s);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            int secondsOfHour = offset.getTotalSeconds() % (60 * 60);  // just seconds!!!

            String out = String.format("%35s %10s%n", zone, offset);
            System.out.printf(out);
        }
    }

    private static void zonedDateTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

        // Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
        LocalDateTime leaving = LocalDateTime.of(2015, Month.JULY, 20, 19, 30);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        String out1 = departure.format(format);
        out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);

        // Flight is 10 hours and 50 minutes, or 650 minutes
        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
                .plusHours(10).plusMinutes(50);

        String out2 = arrival.format(format);
        out.printf("ARRIVING: %s (%s)%n", out2, arrivingZone);

        // літній час
        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) {
            out.printf("  (%s daylight saving time will be in effect.)%n", arrivingZone);
        } else {
            out.printf("  (%s standard time will be in effect.)%n", arrivingZone);
        }
    }

    private static void offsetDateTime() {
        // Find the last Thursday in October 2015.
        LocalDateTime localDate = LocalDateTime.of(2015, Month.OCTOBER, 20, 19, 30);
        ZoneOffset offset = ZoneOffset.of("-08:00");

        OffsetDateTime offsetDate = OffsetDateTime.of(localDate, offset);
        OffsetDateTime lastThursday =
                offsetDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        out.printf("The last Thursday in October 2015 is the %sth.%n",
                lastThursday.getDayOfMonth());


        OffsetDateTime odt = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("-4"));
        out.println(odt);    // 2015-10-13T11:14:03.073-04:00

        OffsetTime ot = OffsetTime.ofInstant(Instant.now(), ZoneId.of("America/Los_Angeles"));
        //OffsetTime ot1 = OffsetTime.ofInstant(Instant.now(), ZoneOffset.of("-2"));
        out.println(ot);     // 01:14:03.073-07:00
    }
}
