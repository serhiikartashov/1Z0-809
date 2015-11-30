package certification.datetime.periodandduration;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class PeriodLauncher {

	public static void main(String[] args) {
		period();
	}

	public static Period period(LocalDate hiringDate) {
		LocalDate today = LocalDate.now();
		return Period.between(hiringDate, today);
	}

	private static void period() {
		System.out.println("period");
		Period employmentPeriod = PeriodLauncher.period(LocalDate.of(2011, Month.FEBRUARY, 1));
		System.out.println(employmentPeriod.getYears()); 		// 4
		System.out.println(employmentPeriod.getMonths()); 		// 8
		System.out.println(employmentPeriod.getDays()); 		// 12
	}

}



