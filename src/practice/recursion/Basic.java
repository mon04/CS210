package practice.recursion;
import java.util.Scanner;
public class Basic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        while(true) {
            int n = scan.nextInt();
            System.out.println("fibonacci: "+fibonacci(n));
            System.out.println("sigma: "+sigma(n));
            System.out.println("factorial: "+factorial(n));
            System.out.println("as a power of two: "+power_PM(2, n));
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

    public static int power(int k, int n) {
        if(n == 0) return 1;
        if(n == 1) return k;
        return k*power(k, n-1);
    }

    public static int power_PM(int k, int n) {
        //PM's example from Lecture 10
        //O(log(n)) time complexity
        if(n == 0) return 1;
        int t = power(k, n/2);
        if(n%2 == 0) return t*t;
        return k*t*t;
    }
}