package CN;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client1_1c {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter character: ");
        char ch = sc.next().charAt(0);

        System.out.print("Enter integer: ");
        int num = sc.nextInt();

        System.out.print("Enter float: ");
        float value = sc.nextFloat();

        DataOutputStream out = new DataOutputStream(s.getOutputStream());    

        out.writeChar(ch);
        out.writeInt(num);
        out.writeFloat(value);
        out.flush();

        System.out.println("Data sent to server.");

        out.close();
        s.close();
        sc.close();
    }
}