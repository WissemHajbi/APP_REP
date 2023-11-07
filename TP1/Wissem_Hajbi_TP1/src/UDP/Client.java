package act4_1;

import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
        	 // Crée une nouvelle socket UDP pour le client
            DatagramSocket clientSocket = new DatagramSocket();
            // Adresse du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost");
            // Ici, "localhost" signifie que le serveur est sur la même machine
            int serverPort = 1235;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Donnez votre prénom :\n");
            String message = scanner.nextLine();
            byte[] sendData = message.getBytes(); 
            // Convertit la saisie de l'utilisateur en tableau de bytes
            // Crée un paquet contenant les données à envoyer, l'adresse du serveur et le port
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            // Envoie le paquet au serveur
            clientSocket.send(sendPacket);
            // Réception de la réponse du serveur
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            // Attends la réponse du serveur
            // Convertit la réponse en une chaîne de caractères
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            // Affiche la réponse du serveur 
            System.out.println(serverResponse);                
           
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