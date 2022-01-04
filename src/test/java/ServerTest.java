import java.net.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    public void testingSocketIsCreated() throws IOException {
        MockSocketWrapper mockSocket = new MockSocketWrapper();

        Server.runEchoServer(mockSocket);

        assertTrue(mockSocket.wasCreateServerSocketCalled());
        assertTrue(mockSocket.wasConnectClientCalled());


    }


    @Test
    public void printsMessage() throws IOException {
        String text = "message was printed :)";

        Utils.print(text);

        assertEquals("message was printed :)", text.trim());

    }


}