package CN;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client1_1b {
    public static void main(String args[])throws Exception{
        
        Socket s = new Socket("localhost",5000);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a flaot value:");
        float num = sc.nextFloat();

        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        out.writeFloat(num);
        out.flush();

        System.out.println("Value sent to server");

        out.close();
        s.close();
        sc.close();
    }   
}
