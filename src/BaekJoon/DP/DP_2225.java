package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점화식 :  dp[K][N] = dp[K-1][0] + dp[K-1][1] + ... + dp[K-1][N]
 *          dp[K][N] = dp[K][N-1] + dp[K-1][N-1]
 */
public class DP_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K+1][N+1];

        for (int i = 0; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }




}
