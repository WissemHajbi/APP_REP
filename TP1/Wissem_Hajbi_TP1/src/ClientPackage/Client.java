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

            InetAddress IA = InetAddress.getByName("10.27.13.29");
		    InetSocketAddress ISA = new InetSocketAddress(IA,1234);

		    Socket client = new Socket();
		    
            client.connect(ISA);
            
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);


            Scanner scanner = new Scanner(System.in);

            System.out.println("donner nb1 = ");
            String nb1 = scanner.nextLine();
            System.out.println("donner nb2 = ");
            String nb2 = scanner.nextLine();

            String op;
            do{
                System.out.println("donner op = ");
                op = scanner.nextLine();
            }while(!(op.equals("+")) && !(op.equals("-")) && !(op.equals("*")) && !(op.equals("/")));


            PrintWriter pw = new PrintWriter(output,true);

            pw.println(nb1);
            pw.println(nb2);
            pw.println(op);


            System.out.println(br.readLine());

        }catch(Exception e){
            System.out.println("CLient here");
            throw new RuntimeException(e);
        }
    }
}
