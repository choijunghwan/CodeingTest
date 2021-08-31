package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BruteForce_1261 {

    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int result = BFS();
        System.out.println(result);

    }

    private static int BFS() {
        PriorityQueue<Miro> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        pq.add(new Miro(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Miro miro = pq.poll();

            if (miro.x == N - 1 && miro.y == M - 1) {
                return miro.count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = miro.x + dx[i];
                int nextY = miro.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    pq.add(new Miro(nextX, nextY, miro.count));
                    visited[nextX][nextY] = true;
                } else if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    pq.add(new Miro(nextX, nextY, miro.count + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return 0;
    }

    static class Miro implements Comparable<Miro>{
        int x;
        int y;
        int count;

        public Miro(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Miro o) {
            return this.count - o.count;
        }
    }
}
