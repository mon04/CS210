package labs.solutions;

import java.util.Scanner;

public class Lab09_Part1 {
    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        System.out.println(f(n));
    }

    public static long f(long n) {
        if(n == 1) return 2;
        return 4*f(n-1)-3*n;
    }
}