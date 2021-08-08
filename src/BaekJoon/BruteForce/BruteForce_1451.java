package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 직사각형의 합의 곱의 최대값을 구하는 것이므로, 전체영역을 모두 포함해야한다.
 */
public class BruteForce_1451 {
    static int[][] map;
    static int N;
    static int M;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        dp = new long[N + 1][M + 1];

        // 거리계산시 나올 수 있는 최댓값 넣어두기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + (long) map[i][j];
            }
        }

        long result = 0;

        for (int i = 1; i <= M - 2; i++) {
            for (int j = i + 1; j <= M - 1; j++) {
                long r1 = sum(1, 1, N, i);
                long r2 = sum(1, i+1, N, j);
                long r3 = sum(1, j+1, N, M);
                if (result < r1 * r2 * r3) {
                    result = r1 * r2 * r3;
                }
            }
        }

        for (int i = 1; i <= N - 2; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                long r1 = sum(1, 1, i, M);
                long r2 = sum(i + 1, 1, j, M);
                long r3 = sum(j + 1, 1, N, M);
                if (result < r1 * r2 * r3) {
                    result = r1 * r2 * r3;
                }
            }
        }

        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= M - 1; j++) {
                long r1 = sum(1, 1, N, j);
                long r2 = sum(1, j + 1, i, M);
                long r3 = sum(i + 1, j + 1, N, M);
                if (result < r1 * r2 * r3) {
                    result = r1 * r2 * r3;
                }

                r1 = sum(1, 1, i, j);
                r2 = sum(i + 1, 1, N, j);
                r3 = sum(1, j + 1, N, M);
                if (result < r1 * r2 * r3) {
                    result = r1 * r2 * r3;
                }
                r1 = sum(1, 1, i, M);
                r2 = sum(i + 1, 1, N, j);
                r3 = sum(i + 1, j + 1, N, M);
                if (result < r1 * r2 * r3) {
                    result = r1 * r2 * r3;
                }
                r1 = sum(1, 1, i, j);
                r2 = sum(1, j + 1, i, M);
                r3 = sum(i + 1, 1, N, M);
                if (result < r1 * r2 * r3) {
                    result = r1 * r2 * r3;
                }
            }
        }

        System.out.println(result);
    }

    private static long sum(int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
    }

}
