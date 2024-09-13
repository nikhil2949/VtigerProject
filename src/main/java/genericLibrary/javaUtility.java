
package genericLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * This is a generic java utility to keep all the java related generic functions
 */
public class javaUtility {
/**
 * This is a generic method to handle current calendar date
 * @author Nikhil A
 * @return 
 */
	public String handlingCalendar(String customizeFormat) {
		Calendar cal=Calendar.getInstance();
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(customizeFormat);
		String currentDate = sdf.format(d);
		return currentDate;
	}
	/**
	 * This is generic function to generate random numbers
	 * @author Nikhil A
	 * @param range
	 * @return
	 */
	public long generateRandomNumbers(Long range) {
		Random r = new Random();
		long num = r.nextLong(range);
		return num;
	}
}
