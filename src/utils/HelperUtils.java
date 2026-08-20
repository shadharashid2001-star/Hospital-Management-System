package utils;

public class HelperUtils {

    private static int idCounter = 1000;


    public static boolean isEmpty(String text) {

        return text == null
                || text.trim().length() == 0;
    }


    public static boolean isEmptyCollection(
            Object[] items,
            int count) {

        return items == null
                || count == 0;
    }


    public static boolean isValidText(String text) {

        return !isEmpty(text);
    }


    public static boolean isValidText(
            String text,
            int minLength) {

        return !isEmpty(text)
                && text.trim().length() >= minLength;
    }


    public static boolean isValidText(
            String text,
            int minLength,
            int maxLength) {

        if (isEmpty(text)) {
            return false;
        }

        int length =
                text.trim().length();

        return length >= minLength
                && length <= maxLength;
    }


    public static String generateId() {

        idCounter++;

        return "ID" + idCounter;
    }


    public static String generateId(
            String prefix) {

        idCounter++;

        return prefix + idCounter;
    }


    public static boolean isPositive(
            int number) {

        return number >= 0;
    }


    public static boolean isPositive(
            double number) {

        return number >= 0;
    }


    public static boolean inRange(
            int value,
            int min,
            int max) {

        return value >= min
                && value <= max;
    }


    public static boolean inRange(
            double value,
            double min,
            double max) {

        return value >= min
                && value <= max;
    }


    public static boolean isValidAge(
            int age) {

        return inRange(
                age,
                0,
                120
        );
    }


    public static boolean isValidPhone(
            String phone) {

        if (isEmpty(phone)) {
            return false;
        }

        int length =
                phone.trim().length();

        return length >= 7
                && length <= 15;
    }


    public static boolean isOneOf(
            String value,
            String[] allowed) {

        if (value == null
                || allowed == null) {

            return false;
        }

        for (int i = 0;
             i < allowed.length;
             i++) {

            if (allowed[i] != null
                    && allowed[i]
                    .equalsIgnoreCase(
                            value.trim()
                    )) {

                return true;
            }
        }

        return false;
    }
}