package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 하나의 섬에 방문하면 섬에서 걸어갈 수 있는 섬들을 DFS에서 착안해 방문합니다.
 * 더이상 연결된 곳이 없다면 방문했던 곳들이 하나의 섬을 이룬것이르 섬의 개수 + 1 해줍니다.
 */
public class Graph_4963 {
    static int[][] maps;
    static boolean[][] visited;
    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 0 0 입력되면 반복 종료
            if (w == 0 && h == 0) {
                break;
            }

            maps = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && maps[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        if (visited[x][y]) {
            return ;
        }

        visited[x][y] = true;
        int[][] routes = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        // 걸어서 갈 수 있는 섬이 있는지 찾아본다.
        for (int[] route : routes) {
            int next_X = x + route[0];
            int next_Y = y + route[1];

            if (0 <= next_X && next_X < h && 0 <= next_Y && next_Y < w && maps[next_X][next_Y] == 1 && !visited[next_X][next_Y]) {
                dfs(next_X, next_Y);
            }
        }
    }
}
