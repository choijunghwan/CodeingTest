package TestCodeReview.Wadiz;

import java.util.HashMap;
import java.util.Map;

public class Solve1 {
    public static void main(String[] args) {
        int[][] passwords = {{101, 1234}, {102, 54321}, {201, 202}, {202, 1}};
        String s = "101#1234#102#654321#51#203#201#202#1#";

        int result = solution(passwords, s);
        System.out.println(result);
    }

    public static int solution(int[][] passwords, String s) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] password : passwords) {
            map.put(password[0], password[1]);
        }

        int answer = 0;
        String[] input = s.split("#");
        for(int i = 0; i < input.length; i++) {
            int houseNum = Integer.parseInt(input[i]);

            if (!map.containsKey(houseNum)) {
                continue;
            }

            // index에러
            int password = Integer.parseInt(input[i+1]);
            if (map.get(houseNum) == password) {
                answer++;
            }
            i++;
        }

        return answer;
    }
}
