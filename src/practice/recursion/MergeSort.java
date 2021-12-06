package practice.recursion;

public class MergeSort {
    public static void main(String[] args) {
        int size = 1000;
        int[] array = new int[size];
        for(int i=0; i < size; i++) {
            array[i] = (int)(Math.random()*size);
        }

        mergeSort(array);
        for(int n: array) {
            System.out.println(n);
        }
    }

    private static void mergeSort(int[] array) {
        int length = array.length;

        if(length < 2) {
            return;
        }

        int mid = length/2;
        int[] left = subArray(array, 0, mid);
        int[] right = subArray(array, mid, length);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] dest, int[] left, int[] right) {
        int d = 0, l = 0, r = 0;
        while(l < left.length && r < right.length) {
            if(left[l] <= right[r])
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

    private static int[] subArray(int[] superArray, int left, int right) {
        int size = right-left;
        int[] out = new int[size];
        System.arraycopy(superArray, left, out, 0, size);
        return out;
    }
}