package ServerPackage;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void  main(String[] args){
        try(ServerSocket ss = new ServerSocket(1234))
        {
            Socket clientSocket = ss.accept();

            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);

            int nb1 = Integer.parseInt(br.readLine());
            int nb2 = Integer.parseInt(br.readLine());
            String op = br.readLine();

            int res = 0;

            switch(op){
                case "+" : res = nb1 + nb2;break;
                case "-" : res = nb1 - nb2;break;
                case "*" : res = nb1 * nb2;break;
                case "/" : res = nb1 / nb2;break;
            }

            PrintWriter pw = new PrintWriter(output,true);
            pw.println(res);



        }catch (IOException e) {
            System.out.println("here");
            throw new RuntimeException(e);
        } ;
    }
}
