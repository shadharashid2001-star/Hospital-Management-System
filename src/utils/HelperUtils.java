package utils;

import java.util.Scanner;

public class HelperUtils {
  private static Integer idCounter = 1000;
  //checks empty

    public static boolean isEmpty(String text){
        return  text == null || text.trim().length()  == 0;
    }

    public static boolean isEmptyCollection(object[] items,int count){
        return  items == null || count == 0;
    }

    // text alone: just must not be empty
    public static boolean isValidText(String text) {
        return !isEmpty(text);
    }

    // text with a minimum length
    public static boolean isValidText(String text, int minLength) {
        return !isEmpty(text) && text.trim().length() >= minLength;
    }

    // text with a minimum and maximum length
    public static boolean isValidText(String text, int minLength, int maxLength) {
        if (isEmpty(text)) {
            return false;
        }
        int length = text.trim().length();
        return length >= minLength && length <= maxLength;
    }
    // no prefix..
    public static String generateId() {
        idCounter = idCounter + 1;
        return "ID" + idCounter;
    }

    // with a prefix: gives ids like "STU1003", "TEA1004" ...
    public static String generateId(String prefix) {
        idCounter = idCounter + 1;
        return prefix + idCounter;
    }
    // range checks

    public static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static boolean inRange(double value, double min, double max) {
        return value >= min && value <= max;
    }
    // age must be between 0 and 120
    public static boolean isValidAge(int age) {
        return inRange(age, 0, 120);
    }
    //length of phone

    public static boolean isValidPhone(String phone) {
        if (isEmpty(phone)) {
            return false;
        }
        int length = phone.trim().length();
        return length >= 7 && length <= 15;
    }
// check when value equals one of the allowed words
public static boolean isOneOf(String value, String[] allowed) {
    if (value == null || allowed == null) {
        return false;
    }
    for (int i = 0; i < allowed.length; i++) {
        if (allowed[i] != null && allowed[i].equalsIgnoreCase(value.trim())) {
            return true;
        }
    }
    return false;
}
}




