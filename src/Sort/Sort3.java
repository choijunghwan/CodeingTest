package Sort;

import java.util.Arrays;

public class Sort3 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;
        int length = citations.length;

        // 오름차순 정렬
        Arrays.sort(citations);

        int count = 0;
        int h = length;

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0 ; j--) {
                if (citations[j] >= h) {
                    count++;
                }
            }
            if (count >= h && ((length - count) <= h)) {
                break;
            }
            count = 0;
            h--;
        }

        answer = h;
        System.out.println("answer = " + answer);
    }
}
