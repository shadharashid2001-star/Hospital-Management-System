package utils;

import java.util.Scanner;

public class InputHandler {

    private Scanner scanner;


    public InputHandler() {

        scanner = new Scanner(System.in);
    }

//text / whole number / decimal
    private boolean isWholeNumber(String line) {

        if (HelperUtils.isEmpty(line)) {
            return false;
        }

        try {

            Integer.parseInt(line.trim());

            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }


    private boolean isDecimalNumber(String line) {

        if (HelperUtils.isEmpty(line)) {
            return false;
        }

        try {

            Double.parseDouble(line.trim());

            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }


    public String readText(String prompt) {

        while (true) {

            System.out.print(prompt + ": ");

            String line = scanner.nextLine();

            if (HelperUtils.isValidText(line)) {

                return line.trim();
            }

            System.out.println(
                    "Please type something. It cannot be empty."
            );
        }
    }


    public int readInt(String prompt) {

        while (true) {

            System.out.print(prompt + ": ");

            String line = scanner.nextLine();

            if (isWholeNumber(line)) {

                return Integer.parseInt(
                        line.trim()
                );
            }

            System.out.println(
                    "Please type a whole number."
            );
        }
    }


    public double readDouble(String prompt) {

        while (true) {

            System.out.print(prompt + ": ");

            String line = scanner.nextLine();

            if (isDecimalNumber(line)) {

                return Double.parseDouble(
                        line.trim()
                );
            }

            System.out.println(
                    "Please type a number. Decimals are allowed."
            );
        }
    }

    
}