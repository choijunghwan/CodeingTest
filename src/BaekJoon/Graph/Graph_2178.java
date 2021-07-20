package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 그래프의 인접 행렬을 이용해 문제를 접근해야 한다.
 * 인접 리스트 대신 인접 행렬을 사용한 이유는 (x,y) 값들의 조회가 빈번하게 일어나므로,
 * 리스트는 순서가 있는 조회는 강하지만, 임의에 부분조회에 약하므로 행렬을 사용.
 * bfs를 이용해서 문제를 풀어간다.
 */
public class Graph_2178 {
    static int N;
    static int M;
    static int result = 999999;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                // 0으로 이동할 수 없는 칸은 true로 변경
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        int result = bfs(0, 0);

        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 1));
        visited[x][y] = true;

        int[][] routes = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int result = 999999;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.getX() == N - 1 && point.getY() == M - 1) {
                result = Math.min(result, point.depth);
                continue;
            }

            for (int[] route : routes) {
                int dx = point.getX() + route[0];
                int dy = point.getY() + route[1];

                if (0 <= dx && dx < N && 0 <= dy && dy < M) {
                    if (map[dx][dy] == 1 && !visited[dx][dy]) {
                        queue.add(new Point(dx,dy, point.getDepth() + 1));
                        visited[dx][dy] = true;
                    }
                }
            }
        }

        return result;
    }
}

class Point {
    int x;
    int y;
    int depth;

    public Point(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDepth() {
        return depth;
    }
}