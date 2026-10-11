package CN;

import java.net.*;
import java.io.*;

public class Client_2 {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);

        String msg;

        while (true) {
            System.out.print("Enter message: ");
            msg = keyboard.readLine();

            out.println(msg);

            if (msg.equals("BYEBYE"))
                break;

            String reply = in.readLine();
            System.out.println("Server reply: " + reply);
        }

        keyboard.close();
        in.close();
        out.close();
        s.close();
    }
}

