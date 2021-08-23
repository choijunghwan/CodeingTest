package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BruteForce_2186 {

    static int N;
    static int M;
    static int K;
    static char[][] map;
    static char[] word;
    static int[][][] dp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        word = br.readLine().toCharArray();
        dp = new int[N][M][word.length];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == word[0]) {
                    ans += dfs(i, j, 0);
                }
            }
        }


        System.out.println(ans);
    }

    private static int dfs(int x, int y, int depth) {

        if (depth + 1 == word.length) {
            return dp[x][y][depth] = 1;
        }
        if (dp[x][y][depth] != -1) {
            return dp[x][y][depth];
        }

        dp[x][y][depth] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= K; j++) {
                int nextX = x + dx[i] * j;
                int nextY = y + dy[i] * j;

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (map[nextX][nextY] == word[depth+1]) {
                    dp[x][y][depth] += dfs(nextX, nextY, depth + 1);
                }
            }
        }

        return dp[x][y][depth];
    }

}
