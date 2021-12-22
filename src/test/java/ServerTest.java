import java.io.*;
import java.net.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import echo.Server;
import org.mockito.Mock;

import java.io.IOException;



class ServerTest {



    @Mock
    Socket clientSocket;


    @Test
    public void practiceTest () throws IOException {
          ServerSocket mockServerSocket = mock(ServerSocket.class);
          Socket mockClientSocket = mock(Socket.class);

          try{
              when(mockServerSocket.accept()).thenReturn(mockClientSocket);
          }
          catch(IOException e){
              Server.errorMessage("error",e);
          }

          mockClientSocket.close();
    }
    @Test
    public void printsMessage () throws IOException {
        String text = "message was printed :)";

        Server.print(text);

        assertEquals("message was printed :)", text.trim());

    }



}