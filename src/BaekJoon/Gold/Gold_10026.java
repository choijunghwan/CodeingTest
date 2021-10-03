package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold_10026 {

    static int N;
    static String[][] maps;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new String[N][N];

        for (int i = 0; i < N; i++) {
            maps[i] = br.readLine().split("");
        }

        isVisited = new boolean[N][N];
        int countA = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    divisionRGB(i, j);
                    countA++;
                }
            }
        }

        isVisited = new boolean[N][N];
        int countB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    divisionRG_B(i, j);
                    countB++;
                }
            }
        }

        System.out.println(countA + " " + countB);


    }

    private static void divisionRG_B(int x, int y) {
        String str = maps[x][y];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll.r + dx[i];
                int nextY = poll.c + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || isVisited[nextX][nextY]) {
                    continue;
                }

                if (str.equals("B")) {
                    if (maps[nextX][nextY].equals(str)) {
                        q.add(new Point(nextX, nextY));
                        isVisited[nextX][nextY] = true;
                    }
                } else {
                    if (maps[nextX][nextY].equals("R") || maps[nextX][nextY].equals("G")) {
                        q.add(new Point(nextX, nextY));
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
        }
    }

    private static void divisionRGB(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll.r + dx[i];
                int nextY = poll.c + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || isVisited[nextX][nextY]) {
                    continue;
                }

                if (maps[nextX][nextY].equals(maps[x][y])) {
                    q.add(new Point(nextX, nextY));
                    isVisited[nextX][nextY] = true;
                }
            }
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
