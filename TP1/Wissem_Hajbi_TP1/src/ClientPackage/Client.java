package ClientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) {
        try {

            // Create an InetAddress object with the specified IP address.
            InetAddress IA = InetAddress.getByName("10.27.13.29");
            InetSocketAddress ISA = new InetSocketAddress(IA, 1234);

            // Create a Socket object and connect to the specified address and port.
            Socket client = new Socket();

            client.connect(ISA);

            // Get input and output streams for communication with the server.
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);

            // Create a Scanner to read input from the user.
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for input.
            System.out.println("donner nb1 = ");
            String nb1 = scanner.nextLine();
            System.out.println("donner nb2 = ");
            String nb2 = scanner.nextLine();

            String op;
            do {
                // Prompt the user for an operation, and loop until a valid operator is entered.
                System.out.println("donner op = ");
                op = scanner.nextLine();
            } while (!(op.equals("+")) && !(op.equals("-")) && !(op.equals("*")) && !(op.equals("/")));

            // Create a PrintWriter to sen  d data to the server.
            PrintWriter pw = new PrintWriter(output, true);

            // Send user input to the server.
            pw.println(nb1);
            pw.println(nb2);
            pw.println(op);

            // Receive and print the server's response.
            System.out.println(br.readLine());

        } catch (Exception e) {
            // Handle any exceptions that may occur during execution.
            System.out.println("CLient here");
            throw new RuntimeException(e);
        }
    }
}
