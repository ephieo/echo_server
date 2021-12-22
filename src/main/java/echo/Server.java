package echo;

import java.io.*;
import java.net.*;
//import java.util.*;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
           serverSocket = createServerSocket(7777);

        } catch(IOException e) {
             errorMessage("Can't listen on port number 7777",e);

        }
        Socket clientSocket = null;
        print("Listening for connection...");

        try{
            clientSocket = connectClient(serverSocket);
        }catch(IOException e){
            errorMessage("***Accept failed!!!***",e);


        }

        print("Connection Successful");
        print("Listening for input");

        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine = null;

        while ((inputLine = input.readLine()) != null) {

            print("echo.Server received : " + inputLine);
            output.println(inputLine);

            if(inputLine.equals("bye")){
                break;
            }
        }
        output.close();
        input.close();
        clientSocket.close();
        serverSocket.close();

    }


    public static ServerSocket createServerSocket ( int port) throws IOException{
        ServerSocket serverSocket = new ServerSocket(port);
        print("***Successful*** " + serverSocket);
        return serverSocket;
    }
    public static Socket connectClient (ServerSocket serverSocket)throws IOException{
       Socket clientSocket = serverSocket.accept();
        return clientSocket ;
    }
    public static void errorMessage (String message, IOException e){
        print(message + e);
        System.exit(1);
    }

    public static void print(String text){
        System.out.println(text);
    }
}