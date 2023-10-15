package CS_Object;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1234)) {
            // Wait for a client to connect
            Socket clientSocket = ss.accept();

            // Set up input stream to receive object
            InputStream input = clientSocket.getInputStream();
            ObjectInputStream oi = new ObjectInputStream(input);

            // Read the received object (Operation)
            Operation op = (Operation) oi.readObject();

            // Extract necessary data from the Operation object
            int nb1 = op.getNb1();
            int nb2 = op.getNb2();
            char ops = op.getOp();

            int res = 0;

            // Perform the requested operation
            switch (ops) {
                case '+':
                    res = nb1 + nb2;
                    break;
                case '-':
                    res = nb1 - nb2;
                    break;
                case '*':
                    res = nb1 * nb2;
                    break;
                case '/':
                    res = nb1 / nb2;
                    break;
            }

            // Store the result in the Operation object
            op.setRes(res);

            // Set up output stream to send the modified Operation object
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(output);

            // Send the modified Operation object back to the client
            oo.writeObject(op);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
