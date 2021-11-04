package BaekJoon.SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solve_13460 {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static boolean[][][][] visited;
    private static int[][] map;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][N][M];
        int r1 = 0;
        int c1 = 0;
        int r2 = 0;
        int c2 = 0;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals(".")) {
                    map[i][j] = 1;
                } else if (split[j].equals("O")) {
                    map[i][j] = 2;
                } else if (split[j].equals("R")) {
                    map[i][j] = 1;
                    r1 = i;
                    c1 = j;
                } else if (split[j].equals("B")) {
                    map[i][j] = 1;
                    r2 = i;
                    c2 = j;
                }
            }
        }

        System.out.println(BFS(r1, c1, r2, c2));



    }

    private static int BFS(int r1, int c1, int r2, int c2) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r1, c1, r2, c2, 1));
        visited[r1][c1][r2][c2] = true;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            if (poll.cnt > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nextRedX = poll.redX;
                int nextRedY = poll.redY;
                int nextBlueX = poll.blueX;
                int nextBlueY = poll.blueY;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while (map[nextRedX + dx[i]][nextRedY + dy[i]] != 0) {
                    nextRedX += dx[i];
                    nextRedY += dy[i];

                    if (map[nextRedX][nextRedY] == 2) {
                        isRedHole = true;
                        break;
                    }
                }

                while (map[nextBlueX + dx[i]][nextBlueY + dy[i]] != 0) {
                    nextBlueX += dx[i];
                    nextBlueY += dy[i];

                    if (map[nextBlueX][nextBlueY] == 2) {
                        isBlueHole = true;
                        break;
                    }
                }

                if (isBlueHole) continue;
                if (isRedHole && !isBlueHole) return poll.cnt;

                if (nextRedX == nextBlueX && nextRedY == nextBlueY) {
                    if (i == 0)  { // 오른쪽으로 기울이기
                        if (poll.redY < poll.blueY) nextRedY -= dy[i];
                        else nextBlueY -= dy[i];
                    } else if (i == 1) {  // 아래쪽으로 기울이기
                        if (poll.redX < poll.blueX) nextRedX -= dx[i];
                        else nextBlueX -= dx[i];
                    } else if (i == 2) {  // 왼쪽으로 기울이기
                        if (poll.redY > poll.blueY) nextRedY -= dy[i];
                        else nextBlueY -= dy[i];
                    } else if (i == 3) {  // 위쪽으로 기울이기
                        if (poll.redX > poll.blueX) nextRedX -= dx[i];
                        else nextBlueX -= dx[i];
                    }
                }

                if (!visited[nextRedX][nextRedY][nextBlueX][nextBlueY]) {
                    visited[nextRedX][nextRedY][nextBlueX][nextBlueY] = true;
                    q.add(new Point(nextRedX, nextRedY, nextBlueX, nextBlueY, poll.cnt + 1));
                }
            }

        }

        return -1;
    }

    static class Point {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int cnt;    // 움직인 횟수

        public Point(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }
}
