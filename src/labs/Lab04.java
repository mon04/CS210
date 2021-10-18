package labs;

import java.util.Scanner;

public class Lab04 {

    public static void main(String[] args) {
        //Input: int

        Scanner scan = new Scanner(System.in);
        int classSize = scan.nextInt(); //Amount students in class
        int x = scan.nextInt(); //Min amount of matches required to pass a sim
        scan.close();

        int sims = 100000;
        int simsPassed = 0; //Stores how many simulations pass the test

        for(int i = 0; i < sims; i++) {

            int[] bdays = new int[365];
            //bdays[i] = amt ppl in class whose bday is on the i'th day of year

            for (int j = 0; j < classSize; j++) {
                int randomDay = (int) (Math.random() * 365);
                bdays[randomDay]++;
            }

            if(enoughStudentsHaveSameBday(bdays, x)) {
                simsPassed++;
            }

        }

        float prob = (float)(simsPassed)/sims; //Probability is sims passes divided by total sims
        System.out.println(Math.rint(prob*100)); //Print probability represented as a percentage
    }

    public static boolean enoughStudentsHaveSameBday(int[] bdays, int min) {
        //Look at each day, check if any of them have enough students with that bday
        for (int count : bdays) {
            if (count >= min) return true;
        }
        return false;
    }
}
