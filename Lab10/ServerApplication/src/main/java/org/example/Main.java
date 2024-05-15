package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameServer gameServer = new GameServer(500);
        gameServer.start();
        System.out.println("ok");
    }
}