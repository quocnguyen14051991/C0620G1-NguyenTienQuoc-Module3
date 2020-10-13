package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static final String REGEX_KH="^KH-[\\d]{4}$";
    public static final String REGEX_SERVICE_ID = "^DV-[\\d]{4}$";
    public static final String REGEX_NAME = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
    public static final String REGEX_PHONE = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$";
    public static final String REGEX_PHONE1 = "^(090|091|[(]84[)][+]90|[(]84[)][+]91)[\\d]{7}$";
    public static final String REGEX_ID_NUMBER = "^([\\d]{9}|[\\d]{12})$";
    public static final String REGEX_EMAIL = "^[\\w.]+@[\\w&&[^_]]+([.][\\w&&[^_]]+){1,2}$";
    public static final String REGEX_POSITIVE_NUMBER = "^([1-9][\\d]*(\\.[\\d]*)?)|(0\\.[\\d]+)$";
    public static final String REGEX_POSITIVE_INTEGER = "^[1-9][\\d]*$";
    public static final String REGEX_ADDRESS="^[A-Z][a-z]{5}$";

    public static boolean isValid(String name,String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean isvalidBirthDay(String date){
        int year= Integer.parseInt(date.split("-")[0]);
        if(year>2000){
            return true;
        }
        return false;
    }
}
