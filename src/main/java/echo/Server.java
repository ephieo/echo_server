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
            Utils.exitErrorMessage(Messages.cantListen(), e);

        }

        Utils.print(Messages.listeningForConnection());

        try {

            this.clientSocket = socketWrapper.connectClient(this.serverSocket);

        } catch (IOException e) {
            Utils.exitErrorMessage(Messages.acceptFailed(), e);


        }

        Utils.print(Messages.connectionSuccessful());
        Utils.print(Messages.listenForInput());

        echoInputOutput(this.clientSocket.getOutputStream(), this.clientSocket.getInputStream());
        socketWrapper.closeApp(this.serverSocket, this.clientSocket, this.output, this.input);


    }

    public void echoInputOutput(OutputStream output, InputStream input) throws IOException {
        this.output = new PrintWriter(output, true);
        this.input = new BufferedReader(new InputStreamReader(input));

        echoMessage(this.output, this.input);
       this.output.flush();

    }

    public void echoMessage(PrintWriter output, BufferedReader input) throws IOException {
        String inputLine = null;
        while ((inputLine = input.readLine()) != null) {

            Utils.print(Messages.echoReceived(inputLine));
            output.println(inputLine);

            if (inputLine.equals(Messages.bye())) {
                break;
            }
        }

    }


}