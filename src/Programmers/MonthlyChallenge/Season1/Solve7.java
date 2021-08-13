package Programmers.MonthlyChallenge.Season1;

public class Solve7 {
    public int solution(int[] a) {
        int answer = 0;
        int[] dp = new int[a.length];
        dp[a.length-1] = a[a.length -1];
        for (int i = a.length -2; i >= 0; i--) {
            if (dp[i+1] > a[i]) {
                dp[i] = a[i];
            } else {
                dp[i] = dp[i+1];
            }
        }

        int leftMin = a[0];

        for (int i = 0; i < a.length; i++) {
            if (i == 0 || i == a.length - 1) {
                answer++;
                continue;
            }

            int mid = a[i];
            if (leftMin > a[i - 1]){
                leftMin = a[i - 1];
            }

            if (mid < leftMin || mid < dp[i+1]){
                answer++;
            }

        }
        return answer;
    }
}
