package TestCodeReview.woowahan;

import java.util.Arrays;

public class Solve4 {

    public int[] solution(String s) {
        int[] arr = new int[1000];

        int idx = 0;
        char block = '0';
        for (int i = 0; i < s.length(); i++) {
            if (block == s.charAt(i)) {
                arr[idx -1]++;
            } else {
                block = s.charAt(i);
                arr[idx] = 1;
                idx++;
            }
        }

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            arr[0] += arr[idx - 1];
            idx--;
        }

        int[] answer = new int[idx];
        for (int i = 0; i < idx; i++) {
            answer[i] = arr[i];
        }

        Arrays.sort(answer);

        return answer;
    }
}
