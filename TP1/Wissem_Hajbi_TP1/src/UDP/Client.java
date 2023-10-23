package UDP;

import java.net.*;

public class Client {
    public static void main(String[] args){
        try{
            // Create an InetAddress object representing the server (localhost in this case)
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Create a DatagramSocket for sending data
            DatagramSocket socket = new DatagramSocket();

            // Define the message you want to send
            String message = "Wissem Hajbi";
            byte[] sendData = message.getBytes();

            // Create a DatagramPacket to send the data to the server at port 1235
            DatagramPacket packetOut = new DatagramPacket(sendData,
                    sendData.length, serverAddress, 1235);

            // Send the packet to the server
            socket.send(packetOut);

        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }
    }
}
