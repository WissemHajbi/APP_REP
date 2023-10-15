package CS_Object;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Define the server's IP address and port
            InetAddress serverAddress = InetAddress.getByName("192.168.1.7");
            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverAddress, 1234);

            // Create a socket to connect to the server
            Socket clientSocket = new Socket();

            // Connect to the server
            clientSocket.connect(serverSocketAddress);

            // Set up output stream to send an Operation object to the server
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(output);

            // Create an Operation object (40 * 20)
            Operation op = new Operation(40, 20, '*');

            // Send the Operation object to the server
            os.writeObject(op);

            // Set up input stream to receive a modified Operation object from the server
            InputStream input = clientSocket.getInputStream();
            ObjectInputStream is = new ObjectInputStream(input);

            // Receive and read the modified Operation object
            op = (Operation) is.readObject();

            // Print the result
            System.out.println("Result received from the server: " + op.getRes());
        } catch (Exception e) {
            System.out.println("Client: An error occurred - " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
