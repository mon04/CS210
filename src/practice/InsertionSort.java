package practice;

public class InsertionSort {
    public static void main(String[] args) {

        int[] nums = {5,2,1,3,6,4};
        System.out.println(array(nums,0));

        for(int i=1; i<nums.length; i++) {

            System.out.println(array(nums,i));

            int temp = nums[i];
            int j = i;

            while(j>0 && nums[j-1]>=temp) {
                nums[j] = nums[j-1]; //shift nums[j-1] to the right:
                j--;
            }
            nums[j] = temp; //insert temp at the empty position:
        }

        System.out.println("----------------\n"+array(nums,-1));

    }


    // Visualisation helpers

    public static String array(int[] a, int i) {
        String out = "";
        for(int n: a) {
            out += n+", ";
        }
        out = out.substring(0,out.length()-2);
        if(i != -1) {
            out += "\n"+underline(i);
        }
        return out;
    }

    public static String underline(int i) {
        String out = "";
        for(int j = 0; j < i; j++) {
            out+="   ";
        }
        return out+"^";
    }
}
