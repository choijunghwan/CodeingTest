package Programmers.KAKAO.BLIND;

import java.util.Arrays;

public class KAKAO_2019_2 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution(N, stages);

        System.out.println(Arrays.toString(result));

    }

    public static int[] solution(int N, int[] stages) {
        int[] arr = new int[N];
        for (int stage : stages) {
            if (stage > N) {
                continue;
            }
            arr[stage -1]++;
        }

        int totalCnt = stages.length;

        double[][] failRate = new double[N][2];

        for (int i = 0; i < N; i++) {
            failRate[i][0] = i + 1;
            failRate[i][1] = totalCnt == 0 ? 0 : (double)arr[i] / totalCnt;
            totalCnt -= arr[i];
        }

        Arrays.sort(failRate, ((o1,o2) -> {
            if (o1[1] == o2[1]) {
                return Double.compare(o1[0], o2[0]);
            } else {
                return Double.compare(o2[1], o1[1]);
            }
        }));

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failRate[i][0];
        }
        return answer;
    }

}
