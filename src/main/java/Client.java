import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 63368);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        out.println("Yury");
        out.flush();
    }
}
