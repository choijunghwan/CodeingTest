package TestCodeReview.Kakao;

public class Solve4 {
    public static void main(String[] args) {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] result = solution(n, info);
    }

    static int[] maxResult;
    static int max = 0;

    public static int[] solution(int n, int[] info) {
        maxResult = new int[info.length];
        int[] output = new int[info.length];

        DFS(0, n, output, info);

        int sum = 0;
        for (int i = 0; i < maxResult.length; i++) {
            sum += maxResult[i];
        }

        return sum == 0 ? new int[]{-1} : maxResult;
    }

    private static void DFS(int idx, int remainArraw, int[] output, int[] info) {

        if (idx == 10 || remainArraw == 0) {
            int diffScore = getDiffScore(info, output);
            if (max < diffScore) {
                max = diffScore;
                convertArray(output);
            } else if (max == diffScore) {
                checkPriority(output);
            }
            return;
        }

        for (int i = 0; i <= remainArraw; i++) {
            output[idx] = i;
            DFS(idx+1, remainArraw - i, output, info);
            output[idx] = 0;
        }

        return;
    }

    private static void convertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            maxResult[i] = arr[i];
        }
    }

    private static void checkPriority(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxResult[i]) {
                convertArray(arr);
                return;
            } else if (arr[i] < maxResult[i]) {
                return;
            }
        }
    }

    private static int getDiffScore(int[] apeach, int[] rion) {
        int apeachScore = 0;
        int rionScore = 0;

        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] > rion[i]) {
                apeachScore += 10 - i;
            } else if (apeach[i] < rion[i]) {
                rionScore += 10 -i;
            } else if (apeach[i] == rion[i]) {
                if (apeach[i] == 0 && rion[i] == 0) {
                    continue;
                }
                apeachScore += 10 - i;
            }
        }

        return rionScore - apeachScore;
    }
}
