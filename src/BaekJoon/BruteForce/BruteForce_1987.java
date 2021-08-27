package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS탐색을 사용
 * List를 이용해 각 알파벳을 담고, 더이상 움직일 곳이 없을때의 사이즈를 리턴한다.
 * 알파벳이니 크기 26 배열을 선언해 비교할 수 있다.
 */
public class BruteForce_1987 {

    static int[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int R;
    static int C;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        DFS(0, 0, 0);
        System.out.println(ans);
    }

    private static void DFS(int row, int col, int count) {

        if (visited[map[row][col]]) {
            ans = Math.max(ans, count);
            return;
        } else {
            visited[map[row][col]] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = row + dx[i];
                int nextY = col + dy[i];

                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
                    continue;
                }

                DFS(nextX, nextY, count + 1);

            }
            visited[map[row][col]] = false;
        }

    }
}
