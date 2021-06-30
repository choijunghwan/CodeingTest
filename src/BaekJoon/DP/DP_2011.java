package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int length = code.length();
        long[] dp = new long[length + 1];

        dp[0] = 1;
        dp[1] = 1;

        if (code.charAt(0) == '0')
            System.out.println("0");
        else if (code.charAt(length -1) == '0' && code.charAt(length -2) != '1' && code.charAt(length -2) != '2')
            System.out.println("0");
        else {
            for (int i = 2; i < length + 1; i++) {
                if (Character.getNumericValue(code.charAt(i - 1)) > 0) {
                    dp[i] += dp[i - 1] % 1000000;
                }
                String str = code.substring(i - 2, i);
                if (10 <= Integer.parseInt(str) && Integer.parseInt(str) <= 26) {
                    dp[i] += dp[i - 2] % 1000000;
                }
            }

            System.out.println(dp[length]% 1000000);
        }



    }
}
