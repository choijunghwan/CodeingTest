package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 인출하는데 필요한 시간이 최소일려면 돈을 뽑는데 걸리는 시간이 적은 순으로 뽑으면 된다.
 */
public class Greedy_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dp[0] = arr[0];
        int result = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i];
            result += dp[i];
        }

        System.out.println(result);
    }
}
