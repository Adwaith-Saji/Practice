package CN;

import java.net.*;
import java.io.*;

public class Server1c {
    public static void main(String args[]) throws Exception {
        ServerSocket ss= new ServerSocket(5000);
        System.out.println("Server Waiting....");

        Socket s1 = ss.accept();
        DataInputStream in = new DataInputStream(s1.getInputStream());

        char ch = in.readChar();
        int num = in.readInt();
        float value = in.readFloat();

        System.out.println("Received: " + ch + " " + num + " " + value);

        ch=(char)(ch+1);
        num=num+10;
        value=value + 5.5f;

        Socket s2 = ss.accept();
        DataOutputStream out = new DataOutputStream(s2.getOutputStream());

        out.writeChar(ch);
        out.writeInt(num);
        out.writeFloat(value);
        out.flush();

        in.close();
        out.close();
        s1.close();
        s2.close();
        ss.close();        

    }   
}
