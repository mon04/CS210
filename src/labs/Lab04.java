package labs;

import java.util.Scanner;

public class Lab04 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int classSize = scan.nextInt();
        int x = scan.nextInt(); //Min amount of matches required to pass a sim
        scan.close();

        int sims = 100000;
        int simsPassed = 0; //Stores how many simulations pass the test

        //Catch cases with obvious results
        if(classSize == 0 || classSize < x) {
            System.out.println(0);
            return;
        } else if(x == 1) {
            System.out.println(100);
            return;
        }

        for(int i = 0; i < sims; i++) {

            //Randomly distribute birthdays
            int[] bdays = new int[365];
            for (int j = 0; j < classSize; j++) {
                bdays[(int)(Math.random()*365)]++;
            }

            //Conduct the test for current sim:
            if(enoughStudentsHaveSameBday(bdays, x)) {
                simsPassed++;
            }

        }

        float prob = (float)(simsPassed)/sims;
        System.out.println((int)Math.rint(prob*100)); //Print probability represented as a percentage

    }

    public static boolean enoughStudentsHaveSameBday(int[] bdays, int min) {
        for (int count : bdays) {
            if (count >= min) return true;
        }
        return false;
    }

}
