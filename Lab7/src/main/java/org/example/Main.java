package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Bag myBag = new Bag(50);
        List<Players> players = new ArrayList<>();

        Players p1 = new Players("A", myBag);
        Players p2 = new Players("B", myBag);

        Thread t1 =new Thread(p1);
        Thread t2 =new Thread(p2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //for(int i = 1; i < 6; i++){
        //   players.add(new Players(String.valueOf(i), myBag));
        //}

        //for(Players p : players ){
        //    Thread t = new Thread(p);
         //   t.join();
        //}
    }
}