import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.Socket;


public class MockSocket extends Socket {
    public ByteArrayInputStream  getInputStream (){
        ByteArrayInputStream input = new ByteArrayInputStream("Hello World".getBytes());
        return input;
    }
    public ByteArrayOutputStream  getOutputStream (){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        return output;
    }
}