import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(63368);
        Socket clientSocket = serverSocket.accept(); // ждем подключения

        System.out.println("New connection accepted");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        final String name = in.readLine();
        System.out.println("Gretting: " + name);

        System.out.printf("Hello, %s, your port is %d%n", name, clientSocket.getPort());
    }
}
