package labs.solutions;

import java.util.Scanner;

public class Lab09_Part2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int y = scan.nextInt();
        float i = scan.nextFloat();
        float x = scan.nextFloat();
        scan.close();
        System.out.printf("%.2f", recursive(x,i,y));
    }

    public static float recursive(float x, float i, int y) {
        if(y-- == 0) return x;
        x += (i*x/100);
        return recursive(x, i, y);
    }
}
