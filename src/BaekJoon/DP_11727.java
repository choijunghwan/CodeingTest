package BaekJoon;

import java.io.*;

public class DP_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) %10007;
        }

        System.out.println(dp[num]);

    }
}
