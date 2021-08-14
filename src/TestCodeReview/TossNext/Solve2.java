package TestCodeReview.TossNext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solve2 {
    public static void main(String[] args) {
        int servers = 2;
        boolean sticky = false;
        int[] requests = {1,2};
        int[][] result = solution(servers, sticky, requests);
        System.out.println(result);
    }

    public static int[][] solution(int servers, boolean sticky, int[] requests) {
        List<Integer>[] list = new ArrayList[servers + 1];
        int[][] answer = new int[servers][];
        for (int i = 0; i <= servers; i++) {
            list[i] = new ArrayList<>();
        }

        int index = 1;
        if (!sticky) { // sticky 옵션 false
            for (int request : requests) {
                list[index++].add(request);

                if (index > servers) index = 1;
            }

            for (int i = 1; i <= servers; i++) {
                answer[i - 1] = new int[list[i].size()];
                int size = 0;
                for (int temp : list[i]) {
                    answer[i-1][size++] = temp;
                }
            }

        } else {  // sticky 옵션 true
            for (int request : requests) {
                boolean containCheck = false;
                for (int i = 1; i <= servers; i++) {
                    if (list[i].contains(request)) {
                        list[i].add(request);
                        containCheck = true;
                        break;
                    }
                }

                if (!containCheck) {
                    list[index++].add(request);
                }
                if (index > servers) index = 1;
            }

            for (int i = 1; i <= servers; i++) {
                answer[i - 1] = new int[list[i].size()];
                int size = 0;
                for (int temp : list[i]) {
                    answer[i-1][size++] = temp;
                }
            }

        }

        return answer;
    }
}
