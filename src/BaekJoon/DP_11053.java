package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * DP를 풀때는 점화식을 떠올리는게 중요하다.
 * 그래서 Top-down 방식이 주를 이루지만, 처음 시작하면 Bottom-up 방식을 많이 사용하게 된다.
 * 우리는 일단 작은것부터 풀고보려는 습성을 많이 가지고 있고
 * 원래 추상화 한뒤에 구체적으로 설계하는 것이 더욱 어렵기 때문이다.
 * 그래서 앞으로는 추상화 한뒤 구체적으로 설계하는 Top-down 방식을 먼저 연습하고 나서,
 * Bottom-up 방식을 사용해야겠다.
 */
public class DP_11053 {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        dp = new int[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < N; i++) {
            LTS(i);
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    static int LTS(int N) {
        if (dp[N] == 0) {
            dp[N] = 1;

            for (int i = N-1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], LTS(i) + 1);
                }
            }
        }

        return dp[N];
    }
}
