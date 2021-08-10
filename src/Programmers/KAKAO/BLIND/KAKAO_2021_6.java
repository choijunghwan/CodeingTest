package Programmers.KAKAO.BLIND;

import java.util.*;

public class KAKAO_2021_6 {
    static class Point {
        int row;
        int col;
        int cnt;

        Point(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    static final int INF = 987654321;
    static int[][] Board;
    static final int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        int[][] board = {{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};
        int r = 1;
        int c = 0;
        int result = solution(board, r, c);
        System.out.println("result = " + result);
    }

    public static int solution(int[][] board, int r, int c) {
        Board = board;
        return permutate(new Point(r,c,0));
    }

    private static int permutate(Point src) {
        int ret = INF;

        for (int num = 1; num <= 6; num++) {
            List<Point> card = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Board[i][j] == num)
                        card.add(new Point(i,j,0));
                }
            }
            if (card.isEmpty()) continue;

            int one = bfs(src, card.get(0)) + bfs(card.get(0), card.get(1)) + 2;
            int two = bfs(src, card.get(1)) + bfs(card.get(1), card.get(0)) + 2;
            for (int i = 0; i < 2; i++)
                Board[card.get(i).row][card.get(i).col] = 0;

            ret = Math.min(ret, one + permutate(card.get(1)));
            ret = Math.min(ret, two + permutate(card.get(0)));

            for (int i = 0; i < 2; i++)
                Board[card.get(i).row][card.get(i).col] = num;
        }

        if (ret == INF) return 0;

        return ret;
    }


    private static int bfs(Point src, Point dst) {
        boolean[][] visited = new boolean[4][4];
        Queue<Point> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()) {
            Point curr = q.poll();
            if(curr.row == dst.row && curr.col == dst.col)
                return curr.cnt;

            for (int i = 0; i < 4; i++) {
                int nr = curr.row + D[i][0], nc = curr.col + D[i][1];
                if (nr < 0 || nr > 3 || nc < 0 || nc > 3) continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.cnt + 1));
                }

                for (int j = 0; j < 2; j++) {
                    if(Board[nr][nc] != 0) break;

                    if(nr + D[i][0] < 0 || nr + D[i][0] > 3 ||
                            nc + D[i][1] < 0 || nc + D[i][1] > 3) continue;

                    nr += D[i][0];
                    nc += D[i][1];
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, curr.cnt + 1));
                }

            }
        }
        return INF;
    }

}
