package helper.logger;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CurrentDateHelper {
	
	private int day, month, year =  0 ;
	private String monthStr = null;
	Calendar calendar;
	
	public void CurrentDateTime() {
		calendar = Calendar.getInstance(TimeZone.getDefault());
		Date date = calendar.getTime();
	}


	public int getDay() {
		CurrentDateTime();
		day = calendar.get(Calendar.DATE);
		return day;
	}

	public String getMonth() {
		CurrentDateTime();
		month = calendar.get(Calendar.MONTH);
		
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    return monthNames[month];
	}

	public int getYear() {
		CurrentDateTime();
		year = calendar.get(Calendar.YEAR);
		return year;
	}
	
	public static void main(String args[]) {
		CurrentDateHelper dateP = new CurrentDateHelper();
		System.out.println("Current Date(dd/mm/yyyy):" +dateP.getDay()+"/"+dateP.getMonth()+"/"+dateP.getYear());
	}
}
