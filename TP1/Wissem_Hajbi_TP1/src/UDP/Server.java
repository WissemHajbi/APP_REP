package act4_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Serveur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			    int serverPort = 1236;
	            DatagramSocket serverSocket = new DatagramSocket(serverPort);
	            System.out.println("Le serveur est en attente de connexions..."); 
	            while (true) { 
	            	
	                byte[] receiveHeure = new byte[1024];
	                // Crée un tableau de bytes pour stocker les données reçues
	                DatagramPacket receivePacketHeure = new DatagramPacket(receiveHeure, receiveHeure.length); 
	                // Crée un paquet pour recevoir des données
	                serverSocket.receive(receivePacketHeure); 
	                // Attend la réception de données depuis un client
	                String clientMessageHeure = new String(receivePacketHeure.getData(), 0, receivePacketHeure.getLength());
	                System.out.println(clientMessageHeure);
	                String heureResponse ="Heure:  "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	                byte[] sendHeure= heureResponse.getBytes(); 
	                // Convertit le message de réponse en tableau de bytes
	                InetAddress clientAddress = receivePacketHeure.getAddress();
	                // Obtient l'adresse IP du client
	                int clientPort = receivePacketHeure.getPort();
	                DatagramPacket sendPacket1 = new DatagramPacket(sendHeure, sendHeure.length, clientAddress, clientPort);
	                // Crée un paquet pour envoyer la réponse au client
	                serverSocket.send(sendPacket1); 
	                // Envoie la réponse au client

		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}