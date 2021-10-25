package TestCodeReview.NaverWebtoon;

import java.util.LinkedList;
import java.util.Queue;

public class Solve1 {

    /**
     * 문자열에서 가장 먼저 나온 유일한 문자를 출력하시오.
     * adacbce  -> d
     * aczefacce -> z
     * abcdfabcd -> f
     */

    /**
     * 문자열에서 문자가 나온 순서대로 Queue에 넣어준다.
     * Queue에서 하나씩 꺼내면서 유일한 문자를 탐색한다.
     */
    public static void main(String[] args) {
        String input = "abcdfabcd";
        String answer = null;

        Queue<Character> queue = new LinkedList<>();

        int[] arr = new int[26];
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            if (arr[index] == 0) {
                queue.add(input.charAt(i));
            }
            arr[index]++;
        }


        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (arr[poll - 'a'] == 1) {
                answer = String.valueOf(poll);
                break;
            }
        }

        System.out.println("answer = " + answer);

    }
}
