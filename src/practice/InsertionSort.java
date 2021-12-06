package practice;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5,2,1,3,6,4};
        printArray(nums,0);
        for(int i=1; i < nums.length; i++) {
            printArray(nums,0);
            int temp = nums[i];
            int j = i;
            while(j>0 && nums[j-1]>=temp) {
                nums[j] = nums[j-1]; //shift nums[j-1] to the right:
                j--;
            }
            nums[j] = temp; //insert temp at the empty position:
        }
        printArray(nums,-1);
    }

    public static void printArray(int[] a, int i) {
        String out = "";
        for(int n: a) {
            out += n+", ";
        }
        out = out.substring(0,out.length()-2);
        if(i != -1) {
            out += "\n";
        }
        System.out.print(out);
    }
}
