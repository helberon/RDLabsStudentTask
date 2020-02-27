package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static List<String> splitStringBySpliterator(String originalString, String spliterator) {
        String[] dividedStrings = StringUtils.split(originalString, spliterator);
        return Arrays.asList(dividedStrings);
    }

    public static int getContainerCounterValue(String counter) {
        List<String> strings = splitStringBySpliterator(counter, "/");
        return Integer.parseInt(StringUtils.getDigits(strings.get(1)));
    }

    public static String getHoursFromTime(String time) {
        return time.split(":")[0];
    }

    public static String getMinutesFromTime(String time) {
        return time.split(":")[1];
    }

}
