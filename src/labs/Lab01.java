package labs;

import java.util.*;

public class Lab01 {
    
    public static void runSolution() {

        Scanner myscanner = new Scanner(System.in);
        //System.out.println("Enter three numbers:");
        int num1 = myscanner.nextInt();
        int num2 = myscanner.nextInt();
        int num3 = myscanner.nextInt();
        myscanner.close();

        printOutlier(num1, num2, num3);
    }


    private static void printOutlier(int n0, int n1, int n2) {

        //Store 3 nums in array
        int[] nums = new int[3];
        nums[0] = n0;
        nums[1] = n1;
        nums[2] = n2;

        sort(nums);

        //Print either the first or last (third) number,
        //whichever has a greater difference from the middle num
        if(Math.abs(nums[0] - nums[1]) == Math.abs(nums[2] - nums[1])){
            //System.out.println(Math.abs(nums[0] - nums[1])+ "=" + Math.abs(nums[2] - nums[1]));
            System.out.println("NA");
        } else if (Math.abs(nums[0] - nums[1]) > Math.abs(nums[2] - nums[1])) {
            //System.out.println(Math.abs(nums[0] - nums[1])+ ">" + Math.abs(nums[2] - nums[1]));
            System.out.println(nums[0]);
        }
        else {
            //System.out.println(Math.abs(nums[0] - nums[1])+ "<" + Math.abs(nums[2] - nums[1]));
            System.out.println(nums[2]);
        }
    }


    public static void sort(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j < nums.length -i; j++) {
                
                if(nums[j] < nums[j-1]) {
                    
                    int swap = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = swap;
                    
                }
            }
        }
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        runSolution();
    }
}