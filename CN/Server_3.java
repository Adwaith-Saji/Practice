package CN;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server_3 {

    static ArrayList<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Chat Server Started...");

        while (true) {
            Socket s = ss.accept();
            System.out.println("Client connected");

            new ClientHandler(s).start();
        }
    }

    static class ClientHandler extends Thread {

        Socket s;
        BufferedReader in;
        PrintWriter out;

        ClientHandler(Socket s) throws Exception {
            this.s = s;

            in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

            out = new PrintWriter(
                s.getOutputStream(), true);

            synchronized (clients) {
                clients.add(out);
            }
        }

        public void run() {
            try {
                String msg;

                while ((msg = in.readLine()) != null) {

                    System.out.println("Received: " + msg);

                    synchronized (clients) {
                        for (PrintWriter client : clients) {
                            client.println(msg);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Client disconnected");
            } finally {
                synchronized (clients) {
                    clients.remove(out);
                }

                try {
                    s.close();
                } catch (Exception e) {
                    // Ignore close errors
                }
            }
        }
    }
}
