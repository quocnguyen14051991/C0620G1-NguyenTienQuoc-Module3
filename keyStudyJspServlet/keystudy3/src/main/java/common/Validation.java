package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean isValid(String name) {
        Pattern pattern = Pattern.compile("^KH-[\\d]{4}$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
