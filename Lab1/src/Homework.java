public class Homework {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String result = "";

        long start = System.nanoTime();

        boolean ok = validate(a, b, k);

        if(ok){
            find(a, b, k, result);
            runningTime(start);
        }

    }

    private static void runningTime(long start) {
        long finish = System.nanoTime();

        long runningTime = finish - start;

        System.out.print("The running time of the app in nanoseconds ");
        System.out.print(runningTime);
    }

    private static boolean validate(int a, int b, int k) {
        if(a >= b) {
            System.out.print("For the program to work, the first number should be lower then the second");
            return false;
        }

        if(k <= 0){
            System.out.println("k (the third number) should be at least one");
            return false;
        }

        return true;
    }

    private static void find(int a, int b, int k, String result) {

        StringBuilder resultBuilder = new StringBuilder(result);
        for(int i = a; i <= b; i++){
            int copie = i;

            while(copie > 9){
                int sum = 0;
                int aux = copie;

                while(aux > 9){
                    sum += ((aux % 10) * (aux % 10));
                    aux /= 10;
                }

                copie = sum + (aux * aux);
            }

            if( copie == k){
                resultBuilder.append(String.valueOf(i));
                resultBuilder.append(" ");
            }
        }

        result = resultBuilder.toString();

        System.out.println(result);
    }
}
