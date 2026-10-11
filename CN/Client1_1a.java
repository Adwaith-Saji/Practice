package CN;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client1_1a {
    public static void main (String args[]) throws Exception{

        Socket s = new Socket("localhost",5000);
        
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter a character: ");
        char ch = sc.next().charAt(0);

        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        out.writeChar(ch);
        out.flush();

        System.out.println("Character sent to server");

        out.close();
        s.close();
        sc.close();
    }     
}
