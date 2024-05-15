package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread {
    private static Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        ClientThread.clientSocket = clientSocket;
    }

    public static void start() throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if(inputLine.equals("stop")) {
                System.out.println("Server stopped");
                out.println("Server stopped");
                out.flush();
                break;
            }

            else{
                System.out.println("Server received the request: " + inputLine);
                out.println("Server received the request " + inputLine);
                out.flush();
            }
        }
        clientSocket.close();
    }
}
