package act4_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost"); 
        // Ici, "localhost" signifie que le serveur est sur la même machine
        int serverPort = 1236;
		String heureMessage = "quelle heure est-il";
        byte[] sendheureMessage = heureMessage.getBytes();
        DatagramPacket sendPacketHeure = new DatagramPacket(sendheureMessage, sendheureMessage.length, serverAddress, serverPort);
        clientSocket.send(sendPacketHeure);
        // Réception de la réponse du serveur
        byte[] receiveHeure = new byte[1024];
        DatagramPacket receivePacket1 = new DatagramPacket(receiveHeure, receiveHeure.length);
        clientSocket.receive(receivePacket1); 
        // Attends la réponse du serveur
        // Convertit la réponse en une chaîne de caractères
        String serverResponse1 = new String(receivePacket1.getData(), 0, receivePacket1.getLength());
        System.out.println(serverResponse1);
        // Ferme la socket du client
        clientSocket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}