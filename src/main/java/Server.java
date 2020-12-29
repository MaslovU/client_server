import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(63368);
        Socket clientSocket = serverSocket.accept(); // ждем подключения

        System.out.println("New connection accepted");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        final String name = in.readLine();

        if (name.isEmpty()) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            out.println("What is your name?");
            out.flush();
        }

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String fromClient = in.readLine();
        final String nameClient = fromClient;

//        System.out.printf("Hello, %s, my port is %d%n", name, clientSocket.getLocalPort());

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        out.println("Are you child? (yes/no)");
        out.flush();

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        fromClient = in.readLine();

        if (fromClient.equals("yes")) {
            out = new PrintWriter(clientSocket.getOutputStream());
            String toClient = String.format("Welcome to the kids area, %s! Let's play!", nameClient);
            out.println(toClient);
            out.flush();
        }

        if (fromClient.equals("no")) {
            out = new PrintWriter(clientSocket.getOutputStream());
            String toClient = String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", nameClient);
            out.println(toClient);
            out.flush();
        }
    }
}
