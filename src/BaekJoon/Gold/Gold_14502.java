package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold_14502 {
    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int[][] map;
    static int[][] wall;
    static List<Dot> virusList = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        wall = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Dot(i, j));
                }
            }
        }

        // 3개의 벽을 세우기 위한 copy map
        wall = copyMap(map);

        setWall(0);
        System.out.println(max);
    }

    // 백트래킹을 이용하여 3개의 벽 세우기
    private static void setWall(int depth) {
        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wall[i][j] == 0) {
                    wall[i][j] = 1;
                    setWall(depth + 1);
                    wall[i][j] = 0;
                }
            }
        }
    }

    private static int getSafeArea(int[][] copyWall) {
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyWall[i][j] == 0) {
                    safe++;
                }
            }
        }
        return safe;
    }

    //  BFS로 바이러스 퍼트리기
    private static void spreadVirus() {
        int[][] copyWall = copyMap(wall);

        // virus를 담는 과정
        Queue<Dot> vq = new LinkedList<>();
        for (int i = 0; i < virusList.size(); i++) {
            vq.offer(new Dot(virusList.get(i).x, virusList.get(i).y));
        }

        while (!vq.isEmpty()) {
            int row = vq.peek().x;
            int col = vq.poll().y;

            for (int k = 0; k < 4; k++) {
                int nextRow = row + dx[k];
                int nextCol = col + dy[k];

                if (isValid(nextRow, nextCol) && copyWall[nextRow][nextCol] == 0) {
                    copyWall[nextRow][nextCol] = 2;
                    vq.offer(new Dot(nextRow, nextCol));
                }
            }
        }

        // 안전구역 크기 체크 후 비교
        int sc = getSafeArea(copyWall);
        max = Math.max(max, sc);

    }

    private static boolean isValid(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return false;
        }
        return true;
    }

    // 기존 맵을 유지하기 위해 바이러스 퍼트릴 맵 복사하기
    private static int[][] copyMap(int[][] arr) {
        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

}
