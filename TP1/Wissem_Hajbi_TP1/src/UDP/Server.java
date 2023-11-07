package act4_1;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		try {
			 int serverPort = 1235; 
	            DatagramSocket serverSocket = new DatagramSocket(serverPort); 
	            // Crée une socket pour le serveur

	            System.out.println("Le serveur est en attente de connexions..."); 

	            while (true) { 
	                byte[] receiveData = new byte[1024]; 
	                // Crée un tableau de bytes pour stocker les données reçues
	                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
	                // Crée un paquet pour recevoir des données
	                serverSocket.receive(receivePacket); 
	                // Attend la réception de données depuis un client
	                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
	                // Convertit les données reçues en une chaîne de caractères
	                InetAddress clientAddress = receivePacket.getAddress();	  
	                int clientPort = receivePacket.getPort(); 
	                // Obtient le port du client et l'adresse IP du client
	                
	                // Réponse au client
	                String welcomeMessage = "Bienvenu " + clientMessage;
	                // Crée un message de réponse
	                byte[] sendData = welcomeMessage.getBytes();
	                // Convertit le message de réponse en tableau de bytes
	                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
	                // Crée un paquet pour envoyer la réponse au client
	                serverSocket.send(sendPacket); 
	                // Envoie la réponse au client
	               
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}