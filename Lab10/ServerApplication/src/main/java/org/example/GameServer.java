package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private int port;

    public GameServer(int port){
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(this.port);

            System.out.println("Server started on port " + this.port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e){
            System.err.println(e);
        } finally {
            serverSocket.close();
        }
    }
}
