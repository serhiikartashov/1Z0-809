package certification.datetime.temporalquery;

import java.time.*;
import java.time.temporal.*;

/**
 * Created by Serhii K. on 07.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {

        // точність
        TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
        System.out.printf("LocalDate precision is %s%n", LocalDate.now().query(query));         // Days
        System.out.printf("LocalDateTime precision is %s%n", LocalDateTime.now().query(query)); // Nanos
        System.out.printf("Year precision is %s%n", Year.now().query(query));                   // Years
        System.out.printf("YearMonth precision is %s%n", YearMonth.now().query(query));         // Months
        System.out.printf("Instant precision is %s%n", Instant.now().query(query));             // Nanos
        System.out.println();

        LocalDateTime date = LocalDateTime.of(2014, Month.DECEMBER, 02, 0, 0);
        ZonedDateTime zonedDate1 = ZonedDateTime.of(date,
                ZoneId.of("Pacific/Chatham"));
        ZonedDateTime zonedDate2 = ZonedDateTime.of(date,
                ZoneId.of("Asia/Dhaka"));

        zoneQueries(zonedDate1, zonedDate2);

        offsetQueries(zonedDate1, zonedDate2);

        customQueries();
    }

    private static void offsetQueries(ZonedDateTime zonedDate1, ZonedDateTime zonedDate2) {
        TemporalQuery<ZoneOffset> query = TemporalQueries.offset();

        ZoneOffset offset1 = zonedDate1.query(query);
        ZoneOffset offset2 = zonedDate2.query(query);

        System.out.println(offset1); // +13:45
        System.out.println(offset2); // +06:00
    }

    private static void zoneQueries(ZonedDateTime zonedDate1, ZonedDateTime zonedDate2) {
        TemporalQuery<ZoneId> query = TemporalQueries.zone();

        ZoneId zoneId1 = zonedDate1.query(query);
        ZoneId zoneId2 = zonedDate2.query(query);

        System.out.println(zoneId1); // "Pacific/Chatham"
        System.out.println(zoneId2); // "Asia/Dhaka"
    }

    private static void customQueries() {
        YearMonth yearMonth = YearMonth.of(2014, 6);
        System.out.println(yearMonth.query(new SchoolHolidayQuery())); // false
        System.out.println(YearMonth.of(2014, Month.JULY).query(new SchoolHolidayQuery())); // true
        System.out.println(YearMonth.of(2014, 8).query(new SchoolHolidayQuery())); // true
        System.out.println();

        YearQuarter yearQuarter1 = YearMonth.of(2014, 6).query(YearQuarterQuery::findQuarter);
        System.out.println(yearQuarter1); // Q2
        YearQuarter yearQuarter2 = YearMonth.of(2011, Month.DECEMBER).query(YearQuarterQuery::findQuarter);
        System.out.println(yearQuarter2); // Q4

    }

}
