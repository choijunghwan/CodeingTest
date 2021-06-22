package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            max = Math.max(max, temp);
        }

        long[] dp = new long[max + 1];
        for (int i = 1; i < max + 1; i++) {
            if (i >= 1 && i <= 3) {
                dp[i] = 1;
            } else if (i == 4 || i == 5) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 5];
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[arr[i]]);
        }
    }
}
