package ServerPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1234)) {
            // Wait for a client to connect and accept the connection.
            Socket clientSocket = ss.accept();

            // Get input and output streams for communication with the client.
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Create a reader to read data from the client.
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);

            // Read the two numbers and the operator from the client.
            int nb1 = Integer.parseInt(br.readLine());
            int nb2 = Integer.parseInt(br.readLine());
            String op = br.readLine();

            int res = 0;

            // Perform the requested operation based on the operator.
            switch (op) {
                case "+":
                    res = nb1 + nb2;
                    break;
                case "-":
                    res = nb1 - nb2;
                    break;
                case "*":
                    res = nb1 * nb2;
                    break;
                case "/":
                    res = nb1 / nb2;
                    break;
            }

            // Create a PrintWriter to send the result back to the client.
            PrintWriter pw = new PrintWriter(output, true);
            pw.println(res);

        } catch (IOException e) {
            // Handle any exceptions that may occur during execution.
            System.out.println("here");
            throw new RuntimeException(e);
        }
    }
}
