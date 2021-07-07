package Sort;


import java.util.Arrays;

public class countingSort {
    static int[] arr;

    public static void main(String[] args) {
        arr = new int[]{10, 9, 3, 5, 16, 20};
        int[] result = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] countArr = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        int[] countSumArr = new int[max+1];
        countSumArr[0] = countArr[0];
        for (int i = 1; i < max + 1; i++) {
            countSumArr[i] = countSumArr[i-1] + countArr[i];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            result[countSumArr[arr[i]] - 1] = arr[i];
            countSumArr[arr[i]]--;
        }

        System.out.println(Arrays.toString(result));

    }
}
