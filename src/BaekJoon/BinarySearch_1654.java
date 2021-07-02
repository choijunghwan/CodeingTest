package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_1654 {
    static int[] arr;
    static int K;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long start = 1;
        long end = arr[K-1];
        long mid = 0;

        while (end >= start) {
            long count = 0;
            mid = (start + end) / 2;
            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }
            if (count < N) {
                end = mid - 1;
            } else if (count >= N) {
                start = mid + 1;
            }
        }

        System.out.println(end);

    }

    private static void recur(int start, int end) {
        int mid = (start + end) / 2;
        int count = 0;

        for (int i = 0; i < K; i++) {
            count += arr[i] / mid;
        }

        if (count < N) {
            recur(start, mid);
        }
        if (count > N) {
            recur(mid + 1, end);
        }

    }
}
