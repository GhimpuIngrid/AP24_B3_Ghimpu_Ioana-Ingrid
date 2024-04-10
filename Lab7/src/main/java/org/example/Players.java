package org.example;

public class Players implements Runnable{
    private String name;
    private Integer[] tokens = new Integer[100];
    private int numberOfTokens;
    private Bag bag;

    public Players(){}

    public Players(String name, Bag bag){
        this.name = name;
        this.bag = bag;
        this.numberOfTokens = 0;
    }

    @Override
    public void run() {
        while(this.bag.getNumberOfTokens() > 0){
            System.out.println(this.bag.getNumberOfTokens());
            int token = 0;
            try {
                token = this.bag.getToken();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

                this.numberOfTokens++;
                this.tokens[this.numberOfTokens] = token;
                System.out.println("Player " + this.name + " got token with value "
                        + this.tokens[numberOfTokens] + " and now has " + this.numberOfTokens
                        + " tokens");


        }

    }
}
