package TestCodeReview.street;

public class Solve2 {

    public int solution(String S) {
        int[] arr = new int[S.length()];
        int index = 0;
        char block = '0';
        int max = 0;
        for (int i = 0; i < S.length(); i++) {
            if (block != S.charAt(i)) {
                arr[index++] = 1;
                block = S.charAt(i);
            } else {
                arr[index - 1]++;
                max = Math.max(max, arr[index - 1]);
            }
        }

        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += max - arr[i];
        }
        return sum;
    }
}
