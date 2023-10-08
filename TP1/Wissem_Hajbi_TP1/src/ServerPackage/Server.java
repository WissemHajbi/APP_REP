package ServerPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void  main(String[] args){
        try(ServerSocket ss = new ServerSocket(1234))
        {
            Socket clientSocket = ss.accept();
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            InetAddress IA = InetAddress.getByName("10.27.15.178");
		    InetSocketAddress ISA = new InetSocketAddress(IA,1234);
		    Socket client = new Socket();
		    client.connect(ISA);

            System.out.println("1");

            int in = input.read();

            System.out.println("2");
            in *= 5;

            System.out.println(in);

            output.write(in);

        }catch (IOException e) {
            System.out.println("here");
            throw new RuntimeException(e);
        } ;
    }
}
