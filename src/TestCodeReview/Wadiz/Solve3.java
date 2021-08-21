package TestCodeReview.Wadiz;

public class Solve3 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 5, 4, 5, 5};
        int result = solution(arr);
        System.out.println(result);

    }

    static int answer = 0;
    public static int solution(int[] arr) {

        partition(arr, 0, arr.length-1);


        return answer;
    }

    private static void partition(int[] arr, int start, int end) {

        int temp = arr[start];

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < temp) {
                partMinus(arr, start, i-1);
                partition(arr, i, end);
                return;
            }
        }

        partMinus(arr, start, end);
    }

    private static void partMinus(int[] arr, int start, int end) {
        if (start == end) {
            // +1
            answer++;
            return;
        }

        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(arr[i],min);
        }

        if (min != 0) {
            answer++;
            for (int i = start; i <= end; i++) {
                arr[i] -= min;
            }
        }

        int x = -1;
        int y = -1;

        for (int i = start; i <= end; i++) {
            if (x != -1 && arr[i] == 0) {
                y = i -1;
                partition(arr, x, y);
                x = -1;
            } else if (arr[i] != 0 && x == -1) {
                x = i;
            }
        }

        if (x != -1) {
            partition(arr, x, end);
        }

    }
}
