package echo;
import java.net.*;

public class Messages {
    public static String listeningForConnection() {
        return "Listening for connection...";
    }
    public static String connectionSuccessful() {
        return "Connection Successful";
    }
    public static String listenForInput() {
        return "Listening for input";
    }
    public static String successful(ServerSocket serverSocket) {
        return "***Successful*** " + serverSocket;
    }

    public static String echoReceived (String inputLine) {
        return "echo.Server received : " + inputLine;
    }

    public static String bye() {
        return "bye";
    }
    public static String acceptFailed() {
        return "***Accept failed!!!***";
    }
    public static String cantListen() {
        return "Can't listen on port number 7777";
    }

}
