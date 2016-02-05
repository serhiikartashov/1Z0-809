package certification.chapter5.datetime.periodandduration;

import java.time.Duration;
import java.time.Instant;

public class DurationLauncher {

	public static void main(String[] args) {
		Instant t1 = Instant.now();
		Instant t2 = Instant.now().plusSeconds(12);
		long nanos = Duration.between(t1, t2).toNanos();
		System.out.println(nanos);				// 12000000000
		long milis = Duration.between(t2, t1).toMillis();
		System.out.println(milis);				// -12000

		Duration gap = Duration.ofSeconds(13);
		Instant later = t1.plus(gap);
		System.out.println(t1); 				// 2015-10-13T08:58:41.312Z
		System.out.println(later); 				// 2015-10-13T08:58:54.312Z

	}

}
