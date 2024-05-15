package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    private String serverAddress = "localhost";
    private int port = 500;

    public GameClient() throws IOException, UnknownHostException {
        Socket clientSocket = new Socket(serverAddress, port);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput = stdIn.readLine();

        while (userInput != null) {
            out.println(userInput);
            if (userInput.equals("exit")) {
                System.out.println("Client has stopped");
                break;
            }

            String response = in.readLine();
            System.out.println(response);

            userInput = stdIn.readLine();
        }
    }
}
