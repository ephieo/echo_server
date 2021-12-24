package echo;

import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws IOException {
        runEchoServer();
    }

    public static ServerSocket serverSocket = null;
        public static Socket clientSocket = null;



    public static void runEchoServer() throws IOException {

        try {
            serverSocket = createServerSocket(7777);

        } catch (IOException e) {
            errorMessage("Can't listen on port number 7777", e);

        }

        print("Listening for connection...");

        try {

            clientSocket = connectClient(serverSocket);

        } catch (IOException e) {
            errorMessage("***Accept failed!!!***", e);


        }

        print("Connection Successful");
        print("Listening for input");

        echoMessage(clientSocket, serverSocket);


    }

    public static ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        print("***Successful*** " + serverSocket);
        return serverSocket;
    }

    public static Socket connectClient(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = serverSocket.accept();
        return clientSocket;
    }

    public static void errorMessage(String message, IOException e) {
        print(message + e);
        System.exit(1);
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void echoMessage(Socket clientSocket, ServerSocket serverSocket) throws IOException {
        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine = null;

        while ((inputLine = input.readLine()) != null) {

            print("echo.Server received : " + inputLine);
            output.println(inputLine);

            if (inputLine.equals("bye")) {
                break;
            }
        }
        closeApp(output, input, clientSocket, serverSocket);
    }

    public static void closeApp(PrintWriter output, BufferedReader input, Socket clientSocket, ServerSocket serverSocket) throws IOException {
        output.close();
        input.close();
        clientSocket.close();
        serverSocket.close();
    }
}