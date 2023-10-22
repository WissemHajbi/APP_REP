package threads;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;




public class Server extends Thread {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {

            ServerSocket socketServeur = new ServerSocket(1214);
            System.out.println("Le serveur attend la connexion d'un client");
            while(true){
                Socket socket = socketServeur.accept();
                System.out.println("un client est connecté");


                socket.close();



            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
