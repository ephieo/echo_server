package echo;

import java.io.*;
import java.net.*;


public class Server {
    SocketWrapper socketWrapper;
    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter output;
    BufferedReader input;


    public Server(SocketWrapper socketWrapper, ServerSocket serverSocket, Socket clientSocket, PrintWriter output, BufferedReader input) {
        this.socketWrapper = socketWrapper;
        this.serverSocket = serverSocket;
        this.clientSocket = clientSocket;
        this.output = output;
        this.input = input;

    }




    public void runEchoServer() throws IOException {

        try {
            this.serverSocket = socketWrapper.createServerSocket(7777);

        } catch (IOException e) {
            Utils.errorMessage(Messages.cantListen(), e);

        }

        Utils.print(Messages.listeningForConnection());

        try {

            this.clientSocket = socketWrapper.connectClient(this.serverSocket);

        } catch (IOException e) {
            Utils.errorMessage(Messages.acceptFailed(), e);


        }

        Utils.print(Messages.connectionSuccessful());
        Utils.print(Messages.listenForInput());


        this.output = new PrintWriter(clientSocket.getOutputStream(), true);
        this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

        socketWrapper.echoMessage(this.output, this.input);
        socketWrapper.closeApp(this.serverSocket, this.clientSocket, this.output, this.input);


    }


}