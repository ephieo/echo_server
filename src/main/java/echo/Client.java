package echo;

import java.io.*;
import java.net.*;
import java.nio.Buffer;

import static java.lang.System.*;

public class Client {

    public static void main(String[] args) throws IOException {

        runClient(args[0],Integer.parseInt(args[1]));
    }

    public static void runClient (String hostname, int portNumber){
        try (
                Socket clientSocket = new Socket(hostname, portNumber);
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("Connected to " + hostname + " on port " + portNumber);
            String userInput;
            while ((userInput = stdInput.readLine()) != null) {
                output.println(userInput);
                System.out.println("echo : " + input.readLine());
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostname);
            System.exit(1);
        }
    }


}

