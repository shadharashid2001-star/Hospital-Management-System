package utils;

public class HelperUtils {

    public static boolean isEmpty(String text) {

        return text == null || text.trim().isEmpty();
    }


    public static boolean isEmpty(Object[] collection) {

        if (collection == null || collection.length == 0) {
            return true;
        }

        for (Object item : collection) {

            if (item != null) {
                return false;
            }
        }

        return true;
    }


    public static boolean isValidText(String text) {

        return !isEmpty(text);
    }


    public static boolean isValidText(
            String text,
            Integer minLength) {

        return !isEmpty(text)
                && text.length() >= minLength;
    }


    public static boolean isValidText(
            String text,
            Integer minLength,
            Integer maxLength) {

        return !isEmpty(text)
                && text.length() >= minLength
                && text.length() <= maxLength;
    }
}