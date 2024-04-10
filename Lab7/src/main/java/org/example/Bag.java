package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Bag {
    private int numberOfTokens;
    private Integer[] tokens;

    public Bag(){}

    public Bag(int n){
        this.numberOfTokens = n;
        this.tokens = new Integer[this.numberOfTokens];
        for(int i = 0; i < n; i++){
            this.tokens[i] = i;
        }
        shuffleTokens();
    }

    public void shuffleTokens(){
        List<Integer> list = Arrays.asList(this.tokens);
        Collections.shuffle(list);
        list.toArray(this.tokens);
    }

    public synchronized int getToken() throws InterruptedException {
        if(this.numberOfTokens == 0)
            return -1;

        int token = this.tokens[this.numberOfTokens - 1];
        this.numberOfTokens--;
        notifyAll();
        wait();
        return token;
    }

    public synchronized int getNumberOfTokens() {
        notifyAll();
        return this.numberOfTokens;
    }
}
