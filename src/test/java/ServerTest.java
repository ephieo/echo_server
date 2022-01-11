import java.io.*;
import java.net.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import echo.Server;
import echo.ServerSocketWrapper;

import echo.Utils;
import org.junit.jupiter.api.Test;


class ServerTest {


    @Test
    public void testingSocketConnection() throws IOException {
        ServerSocket mockServerSocket = mock(ServerSocket.class);
        Socket mockClientSocket = mock(Socket.class);

        try {
            when(mockServerSocket.accept()).thenReturn(mockClientSocket);
        } catch (IOException e) {
            Utils.exitErrorMessage("error", e);
        }


        mockServerSocket.close();
    }

    @Test
    public void testingInputIsEchoedBack() throws IOException {
        MockSocketWrapper mockSocket = new MockSocketWrapper();
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter output = null;
        BufferedReader input = null;
        ByteArrayInputStream mockInput = new ByteArrayInputStream("HELLO".getBytes());
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();

        Server server = new Server(mockSocket, serverSocket, clientSocket, output, input);
        server.echoInputOutput(mockOutput, mockInput);

        assertArrayEquals("HELLO\n".getBytes(), mockOutput.toByteArray());

    }

    @Test
    public void testingMessageIsEchoedBack() throws IOException {
        MockSocketWrapper mockSocket = new MockSocketWrapper();
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        String text = "testing if it bounces back...";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        PrintWriter output = new PrintWriter(mockOutput, true);
        BufferedReader input = new BufferedReader(new InputStreamReader(mockInput));

        Server server = new Server(mockSocket, serverSocket, clientSocket, output, input);
        server.echoMessage(output, input);

        assertEquals("testing if it bounces back...\n", mockOutput.toString());

    }


    @Test
    public void printsMessage() throws IOException {
        String text = "message was printed :)";

        Utils.print(text);

        assertEquals("message was printed :)", text.trim());

    }


}