package labs;

import java.util.Scanner;

public class Lab02 {

    public static void runSolution() {

        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();
        int[] array = {n1, n2, n3};
        scan.close();

        int lcm = lcm(array);
        System.out.println((lcm == -1)? "NA" :lcm);


        //System.out.println((lcm == -1)? "NA" :lcm);

    }

    public static int getLCM(int n1, int n2) {

        return (n1*n2)/getGFC(n1,n2);
    }

    public static int getGFC(int n1, int n2) {
        if(n2 == 0) {
            return n1;
        } else {
            return getGFC(n2, n1%n2);
        }
    }

    public static int lcm(int[] array) {

        for (int i = 1;; i++) {

            int n = array.length;

            for (int num : array) {
                if(num <= 0) {
                    return -1;
                }
                if (i % num != 0) {
                    break;
                }
                if (--n == 0) {
                    return i;
                }

            }
        }
    }

}
