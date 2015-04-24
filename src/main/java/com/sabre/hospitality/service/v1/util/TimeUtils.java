package com.sabre.hospitality.service.v1.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class TimeUtils {

	/**
	 * Returns the default time zone.
	 * @return The default time zone
	 */
	public static DateTimeZone getDefaultTimeZone() {
		return DateTimeZone.getDefault();
	}
	
	/**
	 * Returns the current date time for the default time zone.
	 * @return The current date time
	 */
	public static DateTime getCurrentDateTime() {
		return new DateTime(DateTimeZone.getDefault());		
	}
	
	/**
	 * Returns the current date time for the given time zone.
	 * @param timeZone Used to create an instance of DateTime
	 * @return The current date time
	 */
	public static DateTime getCurrentDateTime(DateTimeZone timeZone) {
		return new DateTime(timeZone);
	}
	
	/**
	 * Returns hours from the given offset .
	 * @param offset A number representing an offset
	 * @return Full hours <-23:+23> from the given offset
	 */
	public static int getHoursFromOffset(double offset) {
		return (int) offset;
	}	
	
	/**
	 * Returns minutes from the given offset.
	 * @param offset A number representing an offset
	 * @return Minutes <-59:+59> from the given offset
	 */
	public static int getMinutesFromOffset(double offset) {
		return (int)(offset * 60) - ((int) offset) * 60;
	}
	
}
