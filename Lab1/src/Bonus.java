public class Bonus {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Graph g = new Graph(n);
        Graph g2 = new Graph(5);
        g.displayGraphMatrix();

        int cycles = g.findCycles();

        System.out.println(cycles);

        g2.displayGraphMatrix();

        System.out.println(g2.findCycles());
    }
}
