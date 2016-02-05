package certification.chapter5.datetime.temporaladjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class FirstTuesdayAdjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal input) {
		LocalDate date = LocalDate.from(input);
		LocalDate nextMonth = date.plusMonths(1);
		LocalDate firstTuesdayInNextMonth = nextMonth.with(TemporalAdjusters
				.firstInMonth(DayOfWeek.TUESDAY));
		return input.with(firstTuesdayInNextMonth);
	}

}




