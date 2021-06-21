package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_2579 {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        if (N == 1) {
            System.out.println(dp[0]);
        } else {
            dp[1] = arr[0] + arr[1];
            recur(N - 1);
            System.out.println(dp[N-1]);
        }

    }

    private static int recur(int N) {
        if (N == 2) {
            return Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        }

        if (dp[N] == 0) {
            dp[N] = Math.max(recur(N - 2) + arr[N], recur(N - 3) + arr[N - 1] + arr[N]);
        }

        return dp[N];
    }
}
