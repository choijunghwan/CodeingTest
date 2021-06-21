package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_1912 {
    static int[] arr;
    static Integer[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        dp[0] = arr[0];
        max = arr[0];

        recur(n - 1);
        System.out.println(max);
    }

    private static int recur(int N) {

        if (dp[N] == null) {
            dp[N] = Math.max(recur(N-1) + arr[N], arr[N]);

            max = Math.max(dp[N], max);
        }

        return dp[N];
    }
}
