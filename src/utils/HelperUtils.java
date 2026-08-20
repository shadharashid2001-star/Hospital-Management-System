package utils;

public class HelperUtils {
    private static Integer idCounter = 1;
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

    public static String generateId() {

        String id = String.valueOf(idCounter);

        idCounter++;

        return id;
    }
    public static String generateId(String prefix) {

        String id = prefix + idCounter;

        idCounter++;

        return id;
    }
    public static boolean isPositive(Integer number) {

        return number != null && number >= 0;
    }
    public static boolean isPositive(double number) {

        return number >= 0;
    }
    public static boolean isInRange(
            Integer number,
            Integer min,
            Integer max) {

        return number != null
                && number >= min
                && number <= max;
    }
    public static boolean isInRange(
            double number,
            double min,
            double max) {

        return number >= min
                && number <= max;
    }

}