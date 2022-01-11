import echo.SocketWrapper;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MockSocketWrapper implements SocketWrapper {
    private boolean createServerCalled = false;
    private boolean connectClientCalled = false;



    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        createServerCalled = true;
        return null;
    }

    @Override
    public Socket connectClient(ServerSocket serverSocket) throws IOException {
        MockSocket mockSocket = new MockSocket();
        return mockSocket;

    }


    @Override
    public void closeApp(ServerSocket serverSocket, Socket clientSocket, PrintWriter output, BufferedReader input) throws IOException {

    }

}