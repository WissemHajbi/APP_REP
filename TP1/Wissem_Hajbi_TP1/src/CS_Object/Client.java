package CS_Object;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try
        {
            InetAddress IA = InetAddress.getByName("192.168.1.7");
		    InetSocketAddress ISA = new InetSocketAddress(IA,1234);

		    Socket client = new Socket();

            client.connect(ISA);

            OutputStream output = client.getOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(output);

            Operation op = new Operation(40,20,'*');

            os.writeObject(op);

            InputStream input = client.getInputStream();
            ObjectInputStream is = new ObjectInputStream(input);

            op = (Operation) is.readObject();

            System.out.println(op.getRes());
        }catch(Exception e){
            System.out.println("CLient here");
            throw new RuntimeException(e);
        }
    }
}
