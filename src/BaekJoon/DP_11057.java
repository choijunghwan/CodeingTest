package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] dp = new int[num+1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= num; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][k] = (dp[i][k] + dp[i-1][j]) % 10007;

                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[num][i]) % 10007;
        }

        System.out.println(result);
    }
}
