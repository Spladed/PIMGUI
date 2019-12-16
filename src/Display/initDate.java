package Display;

import java.util.Calendar;

public class initDate {
	private static Calendar cal=Calendar.getInstance();
	
	public static int getInitDay() {
		return cal.get(Calendar.DATE);
	}
	
	public static int getInitMonth() {
		return cal.get(Calendar.MONTH)+1;
	}
	
	public static int getInitYear() {
		return cal.get(Calendar.YEAR);
	}
}
