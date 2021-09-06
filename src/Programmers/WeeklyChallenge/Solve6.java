package Programmers.WeeklyChallenge;

import java.util.Arrays;
import java.util.Comparator;

public class Solve6 {
    public int[] solution(int[] weights, String[] head2head) {
        double[][] answer = new double[weights.length][4];

        for (int i = 0; i < weights.length; i++) {
            answer[i][0] = i+1;  //선수 번호
            answer[i][3] = weights[i]; //선수 몸무게

            double win = 0;  //이긴횟수
            double cnt = 0;  //싸운횟수
            double heavyWin = 0;  //자기보다 무거운 복서를 이긴 횟수
            for (int j = 0; j < head2head.length; j++) {
                char ch = head2head[i].charAt(j);

                if (ch == 'N') {
                    continue;
                }

                if (ch == 'L') {
                    cnt++;
                    continue;
                }

                win++;
                cnt++;
                if (weights[i] < weights[j]) {
                    heavyWin++;
                }
            }
            answer[i][1] = cnt == 0 ? 0 : win / cnt;
            answer[i][2] = heavyWin;
        }

        Arrays.sort(answer, new CustomComparator());

        int[] result = new int[answer.length];
        for (int i = 0; i < answer.length; i++) {
            result[i] = (int)answer[i][0];
        }

        return result;
    }

    class CustomComparator implements Comparator<double[]> {
        @Override
        public int compare(double[] o1, double[] o2){
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    if (o1[3] == o2[3]) {
                        return Double.compare(o1[0], o2[0]);
                    } else {
                        return Double.compare(o2[3], o1[3]);
                    }
                } else {
                    return Double.compare(o2[2], o1[2]);
                }
            } else {
                return Double.compare(o2[1], o1[1]); //내림차순
            }
        }
    }

}
