package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * bfs를 이용해 풀어줍니다.
 *
 * 1. 섬마다 번호가 똑같으므로 바로 BFS로 다른 섬을 찾아 연결하기가 힘들다. 그러므로 섬에 각각 다른 번호 이름을 붙여줍니다.
 * 2. 이제 섬마다 BFS를 하여 다른 섬과 다리를 설치할 수 있는 경우의 수를 찾아봅니다.
 * 3. 다리를 최소의 개수로 설치한 경우를 업데이트 해줍니다.
 */
public class Graph_2146 {
    static boolean[][] visitIsland;
    static int[][] map;
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visitIsland = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int landNum = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    makeLand(i, j, landNum++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    visitIsland = new boolean[N][N];  //재초기화
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);

    }

    private static void makeLand(int x, int y, int num) {
        Queue<Point> queue = new LinkedList<>();
        visitIsland[x][y] = true;
        queue.add(new Point(x, y, num));
        map[x][y] = num;
        int[][] routes = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int[] route : routes) {
                int dx = point.x + route[0];
                int dy = point.y + route[1];

                if (0 <= dx && dx < N && 0 <= dy && dy < N) { // 지도를 벗어나는 경우는 체크
                    if (map[dx][dy] == 1 && !visitIsland[dx][dy]) {
                        queue.add(new Point(dx, dy, num));
                        visitIsland[dx][dy] = true;
                        map[dx][dy] = num;
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        visitIsland[x][y] = true;
        int currentLandNum = map[x][y];
        queue.add(new Point(x, y, 0));

        int[][] routes = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int[] route : routes) {
                int dx = point.x + route[0];
                int dy = point.y + route[1];

                if (0 <= dx && dx < N && 0 <= dy && dy < N) { // 지도를 벗어나는 경우는 체크
                    if (map[dx][dy] != currentLandNum && !visitIsland[dx][dy]) {
                        visitIsland[dx][dy] = true;

                        if (map[dx][dy] == 0) {  //바다
                            queue.add(new Point(dx, dy, point.cnt + 1));
                        } else { // 다른섬
                            answer = Math.min(answer, point.cnt);
                        }
                    }
                }
            }
        }

    }

    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}


