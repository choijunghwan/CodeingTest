package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 1;
        int end = arr[N-1];


        while (start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] >= mid) {
                    sum += arr[i] - mid;
                }
            }

            if (sum < M) {
                end = mid - 1;
            } else if (sum >= M) {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}
