package labs.solutions;

import java.util.Scanner;

public class Lab04_Improved {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int classSize = scan.nextInt();
        int x = scan.nextInt(); //Min amount of matches required to pass a sim
        scan.close();

        int sims = 100000;
        int simsPassed = 0; //Stores how many simulations pass the test

        for(int i = 0; i < sims; i++) {

            //Randomly distribute birthdays
            int[] bdays = new int[365];
            for (int j = 0; j < classSize; j++) {
                int bday = (int)(Math.random()*365);
                bdays[bday]++;
                if(bdays[bday] >= x) {
                    simsPassed++;
                    break;
                }
            }

        }

        float prob = (float)(simsPassed)/sims;
        System.out.println((int)Math.rint(prob*100)); //Print probability represented as a percentage

    }

}