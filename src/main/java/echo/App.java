package echo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws IOException {
        SocketWrapper socketWrapper = new ServerSocketWrapper();
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter writer = null;
        BufferedReader reader = null;

        Server server = new Server(socketWrapper, serverSocket, clientSocket, writer, reader);
        server.runEchoServer();

    }
}
