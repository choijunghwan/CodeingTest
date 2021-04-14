package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class DP2 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int answer = solution(triangle);
        System.out.println("answer = " + answer);
    }

    /**
     * 층을 기준으로 계산
     *            7
     *          10 15
     *         18 16 15
     *        20 25 19 19
     *       24 30 27 25 24
     *
     * N층이면
     * triangle[N-1][0] = triangle[N-1][0] + triangle[N-2][0]
     * triangle[N-1][1] = triangle[N-1][1] + Max(triangle[N-2][0], triangle[N-2][1])
     *       .
     *       .
     *       .
     * triangle[N-1][N-1] = trianlgle[N-1][N-1] + triangle[N-2][N-2]
     */
    public static int solution(int[][] triangle) {
        int[][] maxTriangle = new int[triangle.length][triangle.length];

        int height = 0;

        while (height != triangle.length) {
            if (height == 0) {
                maxTriangle[0][0] = triangle[0][0];
                height++;
                continue;
            }

            for (int i = 0; i <= height; i++) {
                if (i == 0) {
                    maxTriangle[height][i] = triangle[height][i] + maxTriangle[height - 1][0];
                } else if (i == height) {
                    maxTriangle[height][i] = triangle[height][i] + maxTriangle[height - 1][height - 1];
                } else {
                    maxTriangle[height][i] = triangle[height][i] + Math.max(maxTriangle[height - 1][i - 1], maxTriangle[height - 1][i]);
                }
            }

            height++;
        }

        if (height == 1) {
            return maxTriangle[0][0];
        }

        int max = maxTriangle[height - 1][0];
        for (int i = 0; i < height; i++) {
            if (maxTriangle[height-1][i] > max) max = maxTriangle[height - 1][i];
        }

        return max;

    }

    /**
     * best 코딩방법
     * 스트림을 이용한 배열에서 max값 구하는 방법 알아둘것
     */
    public static int bestSolution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            for (int j = 0; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}
