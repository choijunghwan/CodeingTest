package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_11054 {
    static int[] arr;
    static int[] asc;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        asc = new int[N];
        dp = new int[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
        }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            recur(i);
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static int recur(int N) {
        if (dp[N] == 0) {
            dp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], asc[i] + 1);
                } else if (arr[i] > arr[N]) {
                    dp[N] = Math.max(dp[N], Math.max(asc[i] + 1, recur(i) + 1));
                }
            }
        }
        return dp[N];

    }

    private static int LIS(int N) {
        if (asc[N] == 0) {
            asc[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    asc[N] = Math.max(asc[N], LIS(i) + 1);
                }
            }
        }
        return asc[N];
    }
}
