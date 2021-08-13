package Programmers.MonthlyChallenge.Season1;

public class Solve5 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }
            answer[1] += count;

            int len = s.length() - count;

            String a = "";
            while (len > 0) {
                a = (len % 2) + a;
                len /= 2;
            }

            s = a;
            answer[0]++;
        }

        return answer;
    }
}
