package UDP;

import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
            // Create a DatagramSocket bound to port 1235 for receiving data
            DatagramSocket serverSocket = new DatagramSocket(1235);

            // Create a buffer to store received data
            byte[] receiveData = new byte[1024];

            while(true){
                // Create a DatagramPacket to store incoming data
                DatagramPacket packetIn = new DatagramPacket(receiveData, receiveData.length);

                // Receive data from the client
                serverSocket.receive(packetIn);

                // Convert the received data to a string and print it
                System.out.println("Bonjour " + new String(receiveData, 0, packetIn.getLength()));
            }

        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }
    }
}
