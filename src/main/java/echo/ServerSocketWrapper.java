package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketWrapper implements SocketWrapper {


    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Utils.print(Messages.successful(serverSocket));
        return serverSocket;
    }

    @Override
    public Socket connectClient(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = serverSocket.accept();
        return clientSocket;
    }



    @Override
    public void closeApp(ServerSocket serverSocket, Socket clientSocket, PrintWriter output, BufferedReader input) throws IOException {
        output.close();
        input.close();
        clientSocket.close();
        serverSocket.close();
    }
}
