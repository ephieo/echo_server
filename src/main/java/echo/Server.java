package echo;

import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketWrapper socketWrapper = new ServerSocketWrapper();
        runEchoServer(socketWrapper);
    }

    public static ServerSocket serverSocket = null;
    public static Socket clientSocket = null;
    public static PrintWriter output = null;
    public static BufferedReader input = null;


    public static void runEchoServer(SocketWrapper socketWrapper) throws IOException {

        try {
            serverSocket = socketWrapper.createServerSocket(7777);

        } catch (IOException e) {
            Utils.errorMessage(Messages.cantListen(), e);

        }

        Utils.print(Messages.listeningForConnection());

        try {

            clientSocket = socketWrapper.connectClient(serverSocket);

        } catch (IOException e) {
            Utils.errorMessage(Messages.acceptFailed(), e);


        }

        Utils.print(Messages.connectionSuccessful());
        Utils.print(Messages.listenForInput());


        output = new PrintWriter(clientSocket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        socketWrapper.echoMessage(output, input);
        socketWrapper.closeApp(serverSocket, clientSocket, output, input);


    }


}