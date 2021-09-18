package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_1311 {

    static int N;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1 << N];


        System.out.println(DP(0,0));
    }

    private static int DP(int now, int flag) {
        if (now == N) {
            return 0;
        }

        if (dp[now][flag] != 0) {
            return dp[now][flag];
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) == 0) {
                result = Math.min(result, arr[now][i] + DP(now + 1, flag | (1 << i)));
            }
        }
        dp[now][flag] = result;

        return dp[now][flag];
    }
}
