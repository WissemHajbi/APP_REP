package ClientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args){
        try
        {

            InetAddress IA = InetAddress.getByName("10.27.15.178");
		    InetSocketAddress ISA = new InetSocketAddress(IA,1234);

		    Socket client = new Socket();
		    
            client.connect(ISA);
            
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            System.out.println("connected");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter an integer: ");
            int nb = scanner.nextInt();

            output.write(nb);

            System.out.println(input.read());

        }catch(Exception e){
            System.out.println("CLient here");
            throw new RuntimeException(e);
        }
    }
}
