package KAKAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KAKAOCOMMERS2 {
    public static void main(String[] args) {
        int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        int r = 2;
        List<Integer> Max = new ArrayList<>();

        // 필요한 부품 최고 번호
        int MaxLength = 0;
        for (int i = 0; i < needs.length; i++) {
            MaxLength = Math.max(MaxLength, needs[i].length);
        }

        System.out.println("MaxLength = " + MaxLength);

        boolean[] visited = new boolean[MaxLength];
        int[] arr = new int[MaxLength];
        for (int i = 0; i < MaxLength; i++) {
            arr[i] = i;
            visited[i] = false;
        }

        comb(Max, needs, arr, visited, 0, MaxLength, r);
        Collections.sort(Max, Collections.reverseOrder());
        int answer = Max.get(0);
        System.out.println("answer = " + answer);
    }

    static void comb(List<Integer> Max ,int[][] needs, int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            Max.add(print(needs, arr, visited, n));
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(Max, needs, arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(Max, needs, arr, visited, depth + 1, n, r);
    }


    static int print(int[][] needs, int[] arr, boolean[] visited, int n) {
        List<Integer> robot = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
                robot.add(arr[i]);
            }
        }

        int ResultCount = 0;
        for (int i = 0; i < needs.length; i++) {
            int count = 0;
            for (int j = 0; j < needs[i].length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (needs[i][j] == 1) {
                    count++;
                }
            }
            if (count == 0) {
                ResultCount++;
            }
        }
        System.out.println("ResultCount = " + ResultCount);
        System.out.println();

        return ResultCount;
    }


}
