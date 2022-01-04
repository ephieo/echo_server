package echo;

import java.io.IOException;

public class Utils {
    public static void errorMessage(String message, IOException e) {
        print(message + e);
        System.exit(1);
    }

    public static void print(String text) {
        System.out.println(text);
    }
}
