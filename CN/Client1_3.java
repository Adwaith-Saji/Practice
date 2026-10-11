package CN;
import java.net.*;
import java.io.*;

public class Client1_3 {

    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);
        System.out.println("Connected to chat server");

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);

        Thread receiver = new Thread(() -> {
            try {
                String msg;

                while ((msg = in.readLine()) != null) {
                    System.out.println("\n" + msg);
                    System.out.print("Message: ");
                }
            } catch (Exception e) {
                System.out.println("Connection closed");
            }
        });

        receiver.start();

        String msg;

        while ((msg = keyboard.readLine()) != null) {
            if (msg.equalsIgnoreCase("BYEBYE"))
                break;

            out.println(msg);
        }

        s.close();
        System.exit(0);
    }
}
