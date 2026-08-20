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
    


}