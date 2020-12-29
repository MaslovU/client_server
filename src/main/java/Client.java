import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("netology.homework", 63368);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        out.println("");
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String fromSrever = in.readLine();

        if (fromSrever.equals("What is your name?")) {
            out = new PrintWriter(clientSocket.getOutputStream());
            out.println("Client Netology");
            out.flush();
        }

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        fromSrever = in.readLine();

        if (fromSrever.equals("Are you child? (yes/no)")) {
            out = new PrintWriter(clientSocket.getOutputStream());
            out.println("yes");
            out.flush();
        }

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        fromSrever = in.readLine();
        System.out.println(fromSrever);
    }
}
