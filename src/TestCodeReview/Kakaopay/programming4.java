package TestCodeReview.Kakaopay;

import java.util.Arrays;

public class programming4 {
    public static void main(String[] args) {
        int[] ages = {35, 25, 3, 8, 7};
        int[][] wires = {{1, 2, 5}, {2, 1, 5}, {1, 3, 2}, {3, 4, 2,}, {3, 5, 20}, {4, 5, 1}};
        int[] result = solution(ages, wires);
        System.out.println(Arrays.toString(result));

    }

    // 이 문제를 Graph로 풀수는 없을까요??

    private static int[] solution(int[] ages, int[][] wires) {

        // 2차원 배열에 발전기 번호를 넣지않고 푸는 방법은 없을까요??
        long[][] arr = new long[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = i + 1;
        }

        for (int[] wire : wires) {
            arr[wire[1] - 1][0] = Math.min(arr[wire[1] - 1][0], ages[wire[0] - 1] + wire[2]);
        }

        // 이렇게 2차원 배열 정렬이 효율성이 좋냐/?
        // 아싸리 우선순위 큐에 넣는 경우는 어떤거 같냐?/
        // 왜 2차원 배열 자료구조를 선택했냐??
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            } else {
                return Long.compare(o1[0], o2[0]);
            }
        });

        // 발전기 번호를 return 해주는 것이기 때문에
        // 문제에서 발전기 번호는 100000을 넘지 않는다고 했으므로 int형으로 변환
        int[] answer = new int[ages.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = (int) arr[i][1];
        }
        return answer;
    }
}
