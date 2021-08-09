package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_10971 {
    static int N;
    static int[][] maps;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 1, 0, i);
        }

        System.out.println(ans);

    }

    private static void dfs(int start, int depth, int sum, int depart) {

        if (depth == N) {
            if (maps[start][depart] != 0) {
                sum += maps[start][depart];
                ans = Math.min(ans, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && maps[start][i] != 0) {
                visited[i] = true;

                dfs(i, depth + 1, sum + maps[start][i], depart);

                visited[i] = false;
            }
        }
    }
}
