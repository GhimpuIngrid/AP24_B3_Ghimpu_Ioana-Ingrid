public class Lab1 {
    public static void main(String args[]) {
        compulsory();
    }

    static void compulsory() {
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n = n* 3;
        n = n + Integer.parseInt("1001", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;

        int m;
        int s = 0;
        while(n > 9){
            m = n;
            while(m > 9){
                s = s + m % 10;
                m = m / 10;
            }
            s = s + m;
            n = s;
            s = 0;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}

