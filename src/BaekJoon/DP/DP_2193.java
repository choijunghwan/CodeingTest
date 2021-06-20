package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        long[][] dp = new long[num+1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= num; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        long result = 0;
        for (int i = 0; i < 2; i++) {
            result += dp[num][i];
        }

        System.out.println(result);
    }
}
