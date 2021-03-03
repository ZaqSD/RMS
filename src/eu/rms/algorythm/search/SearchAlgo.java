package eu.rms.algorythm.search;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SearchAlgo {

	public SearchAlgo(String departure, String destination) {

		Calendar cal = new GregorianCalendar();

		Search(departure, destination, cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.DAY_OF_MONTH),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR), true);
	}

	public SearchAlgo(String departure, String destination, int hour, int minute, int day, int month, int year,
			Boolean isNow) {
		Search(departure, destination, hour, minute, day, month, year, isNow);
	}

	private void Search(String departure, String destination, int hour, int minute, int day, int month, int year,
			Boolean isNow) {

		
		
	}
}
