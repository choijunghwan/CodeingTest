package TestCodeReview.DevMatching.last_2021;

import java.util.HashMap;
import java.util.Map;

public class Solve3 {

    public static void main(String[] args) {
        String s = "tooth";

        int result = solution(s);
    }
    // 부분 문자열 구하기
    // 길이가 4인경우 1,2,3,4

    // a b c c
    // ab bc cc
    // abc bcc   ab + bc , bc + cc
    // abcc  ab + bc + cc

    // tooth
    // to oo ot th
    // too oot oth  to + oo, oo + ot, ot + th
    // toot ooth  to + oo + ot, oo + ot + th
    // tooth   to + oo + ot + th
    public static int solution(String s) {

        // 키보드 좌표값 생성
        String[] keyboards = {"qwertyuio", "pasdfghjk", "lzxcvbnm"};
        Map<Character, Point> keyboardMap = new HashMap<>();
        for (int i = 0; i < keyboards.length; i++) {
            String key = keyboards[i];

            for (int j = 0; j < key.length(); j++) {
                keyboardMap.put(keyboards[i].charAt(j), new Point(i, j));
            }
        }


        // 길이가 2인 부분문자열의 문자 사이의 거리 값을 구한다.
        int[] twoLenArr = new int[s.length() - 1];

        for (int i = 0; i < s.length() - 1; i++) {
            char leftCh = s.charAt(i);
            char rightCh = s.charAt(i+1);
            Point leftPoint = keyboardMap.get(leftCh);
            Point rightPoint = keyboardMap.get(rightCh);

            twoLenArr[i] = Math.abs(leftPoint.x - rightPoint.x) + Math.abs(leftPoint.y - rightPoint.y);
        }

        // 길이가 2인 부분문자열중에서
        // 처음과 끝은 len-1 번 더해진다.
        // 가운데는 (len-3)*2 + 2번 더해진다.
        long sum = 0;
        for (int i = 0; i < twoLenArr.length; i++) {
            if (i == 0 || i == twoLenArr.length - 1) {
                sum += twoLenArr[i] * (s.length() - 1);
                sum %= 1000000007;
            } else {
                sum += twoLenArr[i] * ((s.length() - 3) * 2 + 2);
                sum %= 1000000007;
            }
        }
        return (int) sum;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
