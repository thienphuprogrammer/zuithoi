package utilites;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    // Read int
    public static int readInt(String message) throws Exception {
        int number;
        System.out.print(message);
        String input = scanner.nextLine();
        if (!input.matches("[-+]?\\d+")) {
            throw new Exception("Data invalid.");
        } else {
            number = Integer.parseInt(input);
        }
        return number;
    }
    // Read string
    public static String readString(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        if(input.isBlank()) {
            return "";
        }
        return input;
    }
    // Read double
    public static double readDouble(String message) throws Exception {
        System.out.print(message);
        double number;
        String input = scanner.nextLine();
        if (!input.matches("^[-+]?\\d*\\.?\\d+([eE][-+]?\\d+)?$")) {
            throw new Exception("Data invalid.");
        } else {
            number = Double.parseDouble(input);
        }
        return number;
    }
    // Read boolean
    public static boolean readBoolean(String message) throws Exception {
        System.out.print(message);
        String input = scanner.nextLine();
        if (!input.matches("^(true|false|1|0)$")) {
            throw new Exception("Data invalid.");
        } else {
            return Boolean.parseBoolean(input);
        }
    }
}
