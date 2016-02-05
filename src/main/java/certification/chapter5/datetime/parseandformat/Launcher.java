package certification.chapter5.datetime.parseandformat;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Launcher {

	public static void main(String[] args) {

		Instant instant = Instant.parse("2014-07-16T10:15:30.00Z");
		LocalDate localDate = LocalDate.parse("2014-07-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate localDate1 = LocalDate.parse("2014-07-16", DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CANADA));
		LocalDate localDate2 = LocalDate.parse("2014-07-16", DateTimeFormatter.ISO_LOCAL_DATE);
		
		DateTimeFormatter strangeFormat = new DateTimeFormatterBuilder()
		.appendValue(MONTH_OF_YEAR, 2)
		.appendLiteral("**")
		.appendValue(YEAR, 4)
		.appendLiteral("--")
		.appendValue(DAY_OF_MONTH, 2)
        .toFormatter();
		
		LocalDate localDate3 = LocalDate.parse("07**2014--16", strangeFormat);
		
		System.out.println(instant);
		System.out.println(localDate);
		System.out.println(localDate1);
		System.out.println(localDate2);
		System.out.println(localDate3);
		
		LocalDate date = Year.of(2014).atMonth(7).atDay(16);
		String strangeDateFormat = date.format(strangeFormat);
		
		System.out.println(strangeDateFormat);

	}

}
