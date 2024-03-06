public class Graph {
    private int[][] m = new int[100][100];
    private int numberOfV;
    private int numberOfCycles;
    private int[] visited = new int[100];


    public Graph(int n) {

        this.numberOfV = n;

        for(int i = 1; i < n; i++){
            this.m[0][i] = 1;
            this.m[i][0] = 1;
        }


        for(int i = 1; i < n; i++){
            this.m[i][i+1] = 1;
            this.m[i+1][i] = 1;
        }


        this.m[n-1][1] = 1;
        this.m[1][n-1] = 1;
    }

    public void displayGraphMatrix(){
        for(int i = 0; i < this.numberOfV; i++){
            for(int j = 0; j < this.numberOfV; j++) {
                System.out.print(this.m[i][j]);
                System.out.print(" ");
            }
            System.out.print('\n');
        }
    }

    public int findCycles(){


        for(int i = 0; i < this.numberOfV - 2; i++){
            int neighbours = 0;
            getCyclesOfVertex(i, neighbours, i);
            this.visited[i] = 1;
        }

        this.numberOfCycles /= 2;

        //if(this.numberOfCycles == (this.numberOfV*this.numberOfV) - (3 * this.numberOfV) + 3)
           // System.out.println("ok");

        return this.numberOfCycles;
    }

    private void getCyclesOfVertex(int i, int neighbours, int startingVertex) {

        this.visited[i] = 1;

        for(int j = 0; j < this.numberOfV; j++){

            if(this.m[i][j] == 1 && this.visited[j] == 0){
                if( neighbours >= 1 && this.m[j][startingVertex] == 1)
                    this.numberOfCycles++;

                this.visited[j] = 1;
                neighbours++;

                getCyclesOfVertex(j, neighbours, startingVertex);

                this.visited[j] = 0;
                neighbours--;
            }
        }
    }


}
