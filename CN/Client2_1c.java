package CN;

import java.net.*;
import java.io.*;

public class Client2_1c {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);
        DataInputStream in =
            new DataInputStream(s.getInputStream());

        char ch = in.readChar();
        int num = in.readInt();
        float value = in.readFloat();    

        System.out.println("Received data:");
        System.out.println("Character: " + ch);
        System.out.println("Integer: " + num);
        System.out.println("Float: " + value);

        in.close();
        s.close();        
    }
}