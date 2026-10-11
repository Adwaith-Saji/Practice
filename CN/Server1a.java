package CN;
import java.net.*;
import java.io.*;

public class Server1a {
    public static void main(String[] args) throws Exception{

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting for client 1...");

        Socket s1=ss.accept();
        DataInputStream in1 = new DataInputStream(s1.getInputStream());

        char ch = in1.readChar();
        System.out.println("Received :"+ch);

        char result = (char)(ch + 1);

        Socket s2 = ss.accept();
        DataOutputStream out2 = new DataOutputStream(s2.getOutputStream());

        out2.writeChar(result);
        out2.flush();

        System.out.println("Sent : "+result);

        out2.close();
        in1.close();
        s1.close();
        s2.close();
        ss.close();
    }    
}
