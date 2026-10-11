package CN;

import java.net.*;
import java.io.*;
    
public class Server1b {
    public static void main(String[] args) throws Exception{

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting for client 1...");

        Socket s1=ss.accept();
        DataInputStream in = new DataInputStream(s1.getInputStream());

        float num = in.readFloat();
        System.out.println("Receiveed value : "+num);

        float result = (float)Math.pow(num,1.5);
        System.out.println("Value sent : "+result);

        Socket s2 = ss.accept();
        DataOutputStream out = new DataOutputStream(s2.getOutputStream());

        out.writeFloat(result);
        out.flush();

        out.close();
        in.close();
        s1.close();
        s2.close();
        ss.close();
    }
}
