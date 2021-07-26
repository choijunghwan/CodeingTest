package BaekJoon.DC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 버블소트 문제이지만 배열길이가 500000만까지라 O(n^2) 시간 복잡도를 생각하면 무조건 시간초과가 뜬다
 * 머지소트를 이용해서 문제를 풀어야 한다.
 * O(nlogn) 의 시간이 소요된다.
 */
public class DC_1517 {
    static long[] sorted;
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        sorted = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, N - 1);

        System.out.println(count);

    }

    private static void mergeSort(long[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(long[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                sorted[index++] = arr[i++];
            } else {
                sorted[index++] = arr[j++];
                count += mid + 1 - i;
            }
        }

        while (i <= mid) {
            sorted[index++] = arr[i++];
        }
        while (j <= high) {
            sorted[index++] = arr[j++];
        }

        for (int k = low; k <= high; k++) {
            arr[k] = sorted[k];
        }
    }

}
