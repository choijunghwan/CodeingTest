package BaekJoon.SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solve_12100 {

    // DFS를 이용해 모든 경우를 탐색
    // 상, 하, 좌, 우 순으로 탐색
    static int N;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(map, 0);

        System.out.println(ans);
    }

    private static void DFS(int[][] map, int moveCnt) {

        if (moveCnt == 5) {
            int max = getBlockMax(map);
            ans = Math.max(ans, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0) {  // 상
                int[][] board = getUpBlockMap(map);
                DFS(board, moveCnt + 1);
            } else if (i == 1) {  // 하
                int[][] board = getDownBlockMap(map);
                DFS(board, moveCnt + 1);
            } else if (i == 2) {  // 좌
                int[][] board = getLeftBlockMap(map);
                DFS(board, moveCnt + 1);
            } else if (i == 3) {  // 우
                int[][] board = getRightBlockMap(map);
                DFS(board, moveCnt + 1);
            }
        }
    }

    private static int[][] getRightBlockMap(int[][] map) {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            int idx = N - 1;
            int block = 0;

            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    if (block == map[i][j]) {
                        board[i][idx + 1] = block * 2;
                        block = 0;
                    } else {
                        block = map[i][j];
                        board[i][idx--] = block;
                    }
                }
            }
        }

        return board;

    }

    private static int[][] getLeftBlockMap(int[][] map) {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            int idx = 0;
            int block = 0;

            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    if (block == map[i][j]) {
                        board[idx - 1][i] = block * 2;
                        block = 0;
                    } else {
                        block = map[i][j];
                        board[idx++][i] = block;
                    }
                }
            }
        }

        return board;
    }

    private static int[][] getDownBlockMap(int[][] map) {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            int idx = N - 1;
            int block = 0;

            for (int j = N - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    if (block == map[j][i]) {
                        board[idx + 1][i] = block * 2;
                        block = 0;
                    } else {
                        block = map[j][i];
                        board[idx][i] = block;
                        idx--;
                    }
                }
            }
        }

        return board;
    }

    private static int[][] getUpBlockMap(int[][] map) {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            int idx = 0;
            int block = 0;

            for (int j = 0; j < N; j++) {
                if (map[j][i] != 0) {
                    if (block == map[j][i]) {
                        board[idx - 1][i] = block * 2;
                        block = 0;
                    } else {
                        block = map[j][i];
                        board[idx][i] = block;
                        idx++;
                    }
                }
            }
        }

        return board;
    }

    private static int getBlockMax(int[][] map) {
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
}
