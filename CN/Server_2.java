package CN;

import java.net.*;
import java.io.*;

public class Server_2 {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting for client...");

        Socket s = ss.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);

        String msg;

        while (true) {
            msg = in.readLine();

            if (msg == null || msg.equals("BYEBYE"))
                break;

            String result = "";

            for (int i = 0; i < msg.length(); i++) {
                char ch = msg.charAt(i);

                if (ch >= 'A' && ch < 'Z')
                    result += (char)(ch + 1);
                else if (ch == 'Z')
                    result += 'A';
                else if (ch >= 'a' && ch < 'z')
                    result += (char)(ch + 1);
                else if (ch == 'z')
                    result += 'a';
                else if (ch >= '0' && ch < '9')
                    result += (char)(ch + 1);
                else if (ch == '9')
                    result += 'O';
                else
                    result += '.';
            }

            out.println(result);
        }

        System.out.println("Connection closed.");

        in.close();
        out.close();
        s.close();
        ss.close();
    }
}

