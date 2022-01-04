import java.io.*;
import java.net.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import echo.Server;
import echo.Utils;
import org.junit.jupiter.api.Test;


import org.mockito.Mock;

import java.io.IOException;


class ServerTest {






    @Test
    public void testingSocketConnection() throws IOException {
        ServerSocket mockServerSocket = mock(ServerSocket.class);
        Socket mockClientSocket = mock(Socket.class);

        try {
            when(mockServerSocket.accept()).thenReturn(mockClientSocket);
        } catch (IOException e) {
            Utils.errorMessage("error", e);
        }


        mockServerSocket.close();
    }
    @Test
    public void testingSocketCloses() throws IOException {
        ServerSocket mockServerSocket = mock(ServerSocket.class);
        Socket mockClientSocket = mock(Socket.class);
        String inputString = "bye\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());

        when(mockClientSocket.getInputStream()).thenReturn(input);
        when(mockClientSocket.getOutputStream()).thenReturn(output);


        System.setIn(input);
        System.setOut(new PrintStream(output));

        mockServerSocket.close();
        mockClientSocket.close();

        verify(mockClientSocket, times(1)).close();


    }

//    @Test
//    public void testingSocketSendsMessage() throws IOException {
//        Client client = new Client();
//        Server server = new Server();
//        System.out.println(server);
//
//        String fakeMessage = "Merry Christmas :)\n bye\n";
////        String connectMessage = "nc localhost 7777\n";
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        ByteArrayInputStream input = new ByteArrayInputStream(fakeMessage.getBytes());
//
//        client.runClient("localhost",7777);
//        server.runEchoServer();
//
//
//        System.setOut(new PrintStream(output));
//        System.setIn(input);
//
//        assertEquals("Merry Christmas :)\n bye\n".trim(), fakeMessage.trim());
//
//        server.serverSocket.close();
//        server.clientSocket.close();
//
//
//    }

    @Test
    public void printsMessage() throws IOException {
        String text = "message was printed :)";

        Utils.print(text);

        assertEquals("message was printed :)", text.trim());

    }

    @Test
    public void closesOutput() throws IOException {
//      Server server = new Server;
    }


}