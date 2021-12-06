package labs.solutions;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) throws FileNotFoundException {
        //long start = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);
        String[] input = new String[scan.nextInt()];
        for(int i=0; i < input.length; i++){
            input[i] = scan.nextLine();
        }
        mergeSort(input);
        for(String w: input) {
            System.out.println(w);
        }
        //System.out.println(System.currentTimeMillis()-start+"ms runtime");
    }

    private static void mergeSort(String[] array) {
        int length = array.length;
        if(length < 2) {
            return;
        }
        int mid = length/2;
        String[] left = subArray(array, 0, mid);
        String[] right = subArray(array, mid, length);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(String[] dest, String[] left, String[] right) {
        int d = 0, l = 0, r = 0;
        while(l < left.length && r < right.length) {
            int sumLeft = asciiSum(left[l]);
            int sumRight = asciiSum(right[r]);
            if((sumLeft < sumRight) || ((sumLeft == sumRight) && (left[l].compareTo(right[r]) > 0)))
                dest[d++] = left[l++];
            else
                dest[d++] = right[r++];
        }
        while(l < left.length) {
            dest[d++] = left[l++];
        }
        while(r < right.length) {
            dest[d++] = right[r++];
        }
    }

    private static String[] subArray(String[] superArray, int left, int right) {
        int size = right-left;
        String[] out = new String[size];
        System.arraycopy(superArray, left, out, 0, size);
        return out;
    }

    private static int asciiSum(String s) {
        int sum = 0;
        for(char c: s.toCharArray()) {
            sum+=c;
        }
        return sum;
    }
}