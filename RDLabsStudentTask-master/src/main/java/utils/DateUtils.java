package utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;


public class DateUtils {

    public final static String DATEPATTERN = "yyyy-MM-dd";
    public final static String DATEPATTERN_US = "MM/dd/yyyy";
    public final static String DATEPATTERN_UK = "yyyy-dd-MM";
    public final static String MY_DATEPATTERN = "E, dd MMM yyyy";


    public static String getCurrentDateInFormat(String datePattern) {
        DateTime dateTimeUTC = DateTime.now();
        return DateTime.parse(dateTimeUTC.toString()).toString(datePattern);
    }

    public static String getDateInFutureOrPastFromNow(String datePattern, int days, String... fromDate) {
        DateTime startDate = fromDate.length > 0 ? DateTime.parse(fromDate[0], DateTimeFormat.forPattern(datePattern)) : DateTime.now();
        if (days > 0) {
            return DateTime.parse(startDate.plusDays(days).toString()).toString(datePattern);
        } else if (days < 0) {
            return DateTime.parse(startDate.minusDays(days).toString()).toString(datePattern);
        } else {
            return getCurrentDateInFormat(datePattern);
        }
    }
}
