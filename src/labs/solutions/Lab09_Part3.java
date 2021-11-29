package labs.solutions;

import java.util.Scanner;

public class Lab09_Part3 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.printf("%.3f", 1-compliment(n));
    }

    public static float compliment(int n) {
        //Recursive method for probability NO pair share a birthday
        if(n < 2) return 1;
        return (366-n)/365f*compliment(n-1);
    }

    public static float iterative(int classSize) {
        int pairs = 0;
        int sims = 1000000;

        for(int i=0; i < sims; i++) {

            int[] bdays = new int[365];

            int j = classSize;
            while(j-- > 0) {
                int ran = (int)(Math.random()*365);
                bdays[ran]++;

                if (bdays[ran] >= 2) {
                    pairs++;
                    break;
                }
            }
        }
        return (float)pairs/sims;
    }
}