package TestCodeReview.KakaoCommers;

import java.util.ArrayList;

public class KAKAOCOMMERS1 {
    public static void main(String[] args) {
        int[] gift_cards = {4, 5, 3, 2, 1};
        int[] wants = {2, 4, 4, 5, 1};
        int[] output = new int[gift_cards.length];
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[gift_cards.length];
        for (int i = 0; i < gift_cards.length; i++) {
            visited[i] = false;
        }
        int answer = 0;

//        answer = Math.min(answer,perm(gift_cards, output, wants, visited, 0, gift_cards.length));
        perm(gift_cards, output, result, wants, visited, 0, gift_cards.length);
        result.sort(null);
        System.out.println("result = " + result.toString());
        answer = result.get(0);
        System.out.println("answer = " + answer);
    }

    static void perm(int[] arr, int[] output, ArrayList<Integer> result, int[] wants, boolean[] visited, int depth, int n) {
        if (depth == arr.length) {
            int count = 0;
            for (int i = 0; i < output.length; i++) {
                if (output[i] != wants[i]) {
                    count++;
                }
            }
            result.add(count);
            System.out.println("count = " + count);
            return;
//            return count;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, result, wants, visited, depth + 1, n);
                output[depth] = 0;
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
