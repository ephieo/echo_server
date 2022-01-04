package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public interface SocketWrapper {
    ServerSocket createServerSocket(int port) throws IOException ;

    Socket connectClient(ServerSocket serverSocket)throws IOException;

    void echoMessage(PrintWriter output, BufferedReader input)throws IOException;

    void closeApp(ServerSocket serverSocket, Socket clientSocket, PrintWriter output, BufferedReader input)throws IOException;
}
