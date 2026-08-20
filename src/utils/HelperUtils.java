package utils;

public class HelperUtils {

    private static Integer idCounter = 1;


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
}