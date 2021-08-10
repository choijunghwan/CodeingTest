package Programmers.WeeklyChallenge;

import java.util.Arrays;

public class Solve2 {
    public static void main(String[] args) {
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};

        String result = solution(scores);

        System.out.println(result);
    }

    private static String solution(int[][] scores) {
        // 1. 각 학생별로 평균을 구한다.
        int studentNum = scores.length;
        double[] scoreAvg = new double[studentNum];

        // 핵심: 자기 자신을 평가한 점수가 유일한 최고점 or 유일한 최저점 인지 판단한다.
        // 자기 점수를 갖는 배열을 만든뒤, 자기 자신 점수를 따로 저장.
        // 배열을 정렬해, 최저점과 점수가 갖다면, 유일한지 체크
        //              최고점과 점수가 갖다면, 유일한지 체크

        for (int i = 0; i < studentNum; i++) {
            int[] score = new int[studentNum];
            for (int j = 0; j < studentNum; j++) {
                score[j] = scores[j][i];
            }

            scoreAvg[i] = getScoreAvg(score, i);

        }


        // 2. 평균을 갖고 학점을 출력한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < studentNum; i++) {
            double temp = scoreAvg[i];

            sb.append(getGrade(temp));
        }

        return sb.toString();
    }

    private static String getGrade(double num) {
        if (num >= 90) return "A";
        else if (80 <= num && num < 90) return "B";
        else if (70 <= num && num < 80) return "C";
        else if (50 <= num && num < 70) return "D";
        return "F";
    }

    private static double getScoreAvg(int[] score, int num) {
        int selfScore = score[num];
        int len = score.length;

        Arrays.sort(score);

        // 자기 자신을 평가한 점수가 최저점이라면
        if (score[0] == selfScore) {
            // 유일한 점수인지 체크
            if (score[1] != selfScore) {
                score[0] = 0;
                len--;
            }
        }
        // 자기 자신을 평가한 점수가 최고점이라면
        else if (score[len - 1] == selfScore) {
            // 유일한 점수인지 체크
            if (score[len - 2] != selfScore) {
                score[len - 1] = 0;
                len--;
            }
        }

        return getScoreSum(score, len);
    }

    private static double getScoreSum(int[] score, int len) {
        int sum = 0;
        for (int s : score) {
            sum += s;
        }

        return sum / len;
    }
}
