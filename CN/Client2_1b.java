package CN;

import java.net.*;
import java.io.*;

public class Client2_1b {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost",5000);

        DataInputStream in = new DataInputStream(s.getInputStream());

        float result = in.readFloat();
        System.out.println("Received value : "+result);

        in.close();
        s.close();
        
    }
}
