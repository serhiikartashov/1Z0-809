package certification.datetime;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class Examples {

	public static void main(String[] args) {
		partialAndInformation();
		timeInformation();
		calculations();
	}

	public static void partialAndInformation() {

		LocalDate date = LocalDate.of(2014, Month.FEBRUARY, 15); // 2014-02-15
		Month february = date.getMonth();
		february.getValue(); // = 2

		Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY

		date.getYear(); // 2014
		date.getDayOfYear(); // 46

		Year year_2014 = Year.of(2014);
		year_2014.isLeap(); // false

		DayOfWeek dayOfWeek = date.getDayOfWeek(); // SATURDAY

		dayOfWeek = DayOfWeek.FRIDAY;
		//Locale.setDefault(Locale.FRENCH);
		Locale locale = Locale.getDefault();
		System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, locale)); // Friday
		System.out.println(dayOfWeek.getDisplayName(TextStyle.NARROW, locale)); // F
		System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, locale)); // Fri

	}

	private static void timeInformation() {
		System.out.println("timeInformation");

		LocalTime time = LocalTime.of(15, 30, 23, 234); // 15:30:00
		System.out.println(time.getHour()); // 15
		System.out.println(time.getMinute()); // 30
		System.out.println(time.getSecond()); // 23
		System.out.println(time.getNano()); // 234
		System.out.println(time.toSecondOfDay()); // 55823
		System.out.println(time.toNanoOfDay()); // 55823000000234

	}

	private static void calculations() {
		// Immutable objects are returned
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		LocalDate yesterday = LocalDate.now().minusDays(1);
		LocalDate lastWeek = LocalDate.now().minusWeeks(1);
		LocalDate nextYear = LocalDate.now().plusYears(1);
		LocalDateTime inThreeHoursAndTwentyMinutes = LocalDateTime.now().plusHours(3).plusMinutes(20);
	}

}