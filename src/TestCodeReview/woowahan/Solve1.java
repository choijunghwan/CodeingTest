package TestCodeReview.woowahan;

public class Solve1 {

    public int[] solution(int[] arr) {
        int[] answer = new int[3];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            answer[arr[i]-1]++;
            max = Math.max(max, answer[arr[i] - 1]);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = max - answer[i];
        }

        return answer;
    }
}
