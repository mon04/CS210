package labs.solutions;

import java.util.Scanner;

public class Lab02_PM {

    public static void main(String[] args) {
        //Input: (int, int, int)

        Scanner scan = new Scanner(System.in);
        int one = Math.abs(scan.nextInt());
        int two = Math.abs(scan.nextInt());
        int three = Math.abs(scan.nextInt());
        int min = Math.min(Math.min(one, two), three);

        if (one + two + three == 0) {
            System.out.println("0");
        } else if (one == 0 || two == 0 || three == 0) {
            System.out.println("NA");
        } else {
            int multiple = min;
            while (!(multiple % one == 0 && multiple % two == 0 && multiple % three == 0)) {
                multiple = multiple + min;
            }
            System.out.println(multiple);
        }
    }
}
