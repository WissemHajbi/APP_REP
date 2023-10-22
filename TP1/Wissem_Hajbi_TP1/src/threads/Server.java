package threads;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    int ord = 0; // Initialize an order counter.
    ServerSocket ss; // ServerSocket for accepting client connections.

    public static void main(String[] args) throws IOException {
        new Server().start(); // Start the server thread.
    }

    public void run() {
        try (ServerSocket ss = new ServerSocket(1234);) {
            while (true) {
                Socket s = ss.accept(); // Accept incoming client connections.
                new ClientProcess(s, ord++).start(); // Create a new thread to handle the client and increment the order counter.
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Inner class to handle client connections.
    public class ClientProcess extends Thread {
        Socket s; // The client socket.
        int ord; // Order in which the client connected.

        public ClientProcess(Socket s, int ord) {
            this.s = s;
            this.ord = ord;
        }

        public void run() {
            System.out.println("Client connected " + s.getRemoteSocketAddress() + " order: " + this.ord);

            // Set up input stream to receive a modified Operation object from the server
            InputStream input = null;
            try {
                input = s.getInputStream();
                ObjectInputStream is = new ObjectInputStream(input);

                // Receive and read the modified Operation object
                Operation op = (Operation) is.readObject();

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
                OutputStream output = s.getOutputStream();
                ObjectOutputStream oo = new ObjectOutputStream(output);

                // Send the modified Operation object back to the client
                oo.writeObject(op);

                s.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
