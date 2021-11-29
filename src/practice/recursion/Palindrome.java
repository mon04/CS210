package practice.recursion;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("Enter some text: ");
            String check = scan.nextLine();
            System.out.println(isPalindromeRecursive(check.toUpperCase()));
        }
    }

    public static boolean isPalindromeRecursive(String s) {
        if(s.length() < 2) return true;
        if(s.charAt(0) != s.charAt( s.length()-1 )) return false;
        return isPalindromeRecursive(s.substring( 1, s.length()-1 ));
    }

    public static boolean isPalindromeIterative(String s) {
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}
