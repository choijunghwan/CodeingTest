package TestCodeReview.Line;

import java.util.ArrayList;
import java.util.List;

public class Solve4 {

    //소수 여부, 소수 아니면 true, 소수 false
    boolean[] isNotPrime;
    List<Integer> list = new ArrayList<>();
    public int[] solution(int n) {
        isNotPrime = new boolean[n+1];

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i*i; j < n+1; j += i) {
                isNotPrime[j] = true;
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        mixArr(arr);

        int[] answer = new int[list.size()];
        int index = 0;
        for (int l : list) {
            answer[index++] = l;
        }
        return answer;
    }

    private void mixArr(int[] arr) {
        int len = arr.length;

        if (len == 1) {
            list.add(arr[0]);
            return;
        }

        int p = 0;
        for (int i = 2; i <= len; i++) {
            if (!isNotPrime[i] && (len % i) == 0) {
                p = i;
                break;
            }
        }

        // len = 6, p = 2
        int[][] subArr = getSubArr(arr, len, p);

        for (int i = 0; i < p; i++) {
            mixArr(subArr[i]);
        }
    }

    // p개의 배열로 분할
    private int[][] getSubArr(int[] arr, int len, int p) {
        int[][] subArr = new int[p][len / p];
        int index = 0;
        for (int i = 0; i < arr.length; i += p) {
            for (int j = 0; j < p; j++) {
                subArr[j][index] = arr[i + j];
            }
            index++;
        }
        return subArr;
    }
}
