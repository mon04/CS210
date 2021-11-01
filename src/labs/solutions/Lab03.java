package labs.solutions;

import java.util.Scanner;

public class Lab03 {

    public static void main(String[] args) {
        //Input: int

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        System.out.print(primeDistance(n));
    }

    public static int primeDistance(int n) {

        int low = n;
        while(!isPrime(low)) {
            low--;
        }

        while(!isPrime(n+1)) {
            n++;
        }

        return (n-low+1);
    }

    public static boolean isPrime(int n) {
        for(int i = 2; i < n/2; i++) {
            if(n%i == 0) return false;
        }
        //No even divisor in range[2, n/2], so n is prime
        return true;
    }
}
