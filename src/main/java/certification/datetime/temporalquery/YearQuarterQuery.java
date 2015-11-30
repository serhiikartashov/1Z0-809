package certification.datetime.temporalquery;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class YearQuarterQuery {

	public static YearQuarter findQuarter(TemporalAccessor date) {
		int month = date.get(ChronoField.MONTH_OF_YEAR);
		if (month >= 1 && month <= 3) {
			return YearQuarter.Q1;
		} else if (month >= 4 && month <= 6) {
			return YearQuarter.Q2;
		} else if (month >= 7 && month <= 9) {
			return YearQuarter.Q3;
		} else {
			return YearQuarter.Q4;
		}
	}
}



