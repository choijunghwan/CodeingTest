package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_2003 {

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

        System.out.println(twoPointer(arr, M));

    }

    private static int twoPointer(int[] arr, int m) {
        int count = 0;
        int start = 0;
        int end = 0;
        int len = arr.length;
        int sum = 0;

        while (true) {

            if (sum >= m) {
                sum -= arr[start++];
            } else if (end >= len) {
                break;
            } else {
                sum += arr[end++];
            }

            if (sum == m) {
                count++;
            }
        }

        return count;

    }

}
