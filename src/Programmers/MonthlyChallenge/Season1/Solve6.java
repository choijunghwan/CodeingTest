package Programmers.MonthlyChallenge.Season1;

import java.util.Arrays;

public class Solve6 {

    static int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];

        quadTree(arr, 0,0, arr.length);

        return answer;
    }

    private void quadTree(int[][] arr, int x, int y, int len) {
        if (len == 1) {
            answer[arr[x][y]]++;
            return ;
        }

        if (check(arr, x, y, len)) {
            answer[arr[x][y]]++;
            return ;
        }

        // len = 4
        // 0,0  0,2  2,0  2,2
        quadTree(arr, x, y, len/2);
        quadTree(arr, x, y + len/2, len/2);
        quadTree(arr, x + len/2, y, len/2);
        quadTree(arr, x + len/2, y + len/2, len/2);
    }

    private boolean check(int[][] arr, int x, int y, int len) {
        int temp = arr[x][y];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[x + i][y + i] != temp) {
                    return false;
                }
            }
        }

        return true;
    }
}
