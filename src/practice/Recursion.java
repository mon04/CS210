package practice;
import java.util.Scanner;
public class Recursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        while(true) {
            int n = scan.nextInt();
            System.out.println("fibonacci: "+fibonacci(n));
            System.out.println("sigma: "+sigma(n));
            System.out.println("factorial: "+factorial(n));
        }
    }

    public static int fibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static int sigma(int n) {
        if(n == 1) return n;
        return n+sigma(n-1);
    }

    public static int factorial(int n) {
        if(n == 1) return n;
        return n*factorial(n-1);
    }
}