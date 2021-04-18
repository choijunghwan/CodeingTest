package DynamicProgramming;

import java.util.ArrayList;

public class DP4 {
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};

        int answer = solution(money);
        System.out.println("answer = " + answer);
    }


    /**
     * 두번째 전의 최대 돈에 현재 번째 집의 돈을 합친것과 이전의 최대 돈을 비교한다.
     * dp[N] = dp[N-2] + money[N] or dp[N-1]
     *
     * 다만 첫번째 집을 훔친경우와, 첫번째 집을 훔치지 않은 경우 두가지로 나눠준다.
     */
    public static int solution(int[] money) {
        int length = money.length;
        // 첫번째 집을 훔친경우, 마지막 집을 훔치지 못하므로 length-1
        int[] dp = new int[length - 1];
        // 첫번째 집을 훔치지 않은경우 length까지
        int[] dp2 = new int[length];

        dp[0] = money[0];
        dp[1] = money[0];
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }
        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }

        return Math.max(dp[length - 2], dp2[length - 1]);
    }
}
