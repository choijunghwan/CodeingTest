package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold_2206 {

    static int N,M,ans;
    static int[][] map, visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        ans = Integer.MAX_VALUE;

        bfs(0, 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    private static void bfs(int y, int x) {
        Queue<Place> q = new LinkedList<>();

        q.add(new Place(y, x, 1, 0));
        visit[y][x] = 0;

        while (!q.isEmpty()) {
            Place p = q.poll();

            // 도착지점 만나면 종료
            if (p.y == N - 1 && p.x == M - 1) {
                ans = p.dis;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }

                if (visit[ny][nx] <= p.drill) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    visit[ny][nx] = p.drill;
                    q.add(new Place(ny, nx, p.dis + 1, p.drill));
                } else {
                    if (p.drill == 0) {
                        visit[ny][nx] = p.drill + 1;
                        q.add(new Place(ny, nx, p.dis + 1, p.drill + 1));
                    }
                }
            }
        }
    }


    static class Place {
        int y;
        int x;
        int dis;  // 이동거리
        int drill; // 공사횟수

        public Place(int y, int x, int dis, int drill) {
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.drill = drill;
        }
    }
}
