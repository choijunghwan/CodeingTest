package Programmers.KAKAO.intern;

import java.util.LinkedList;
import java.util.Queue;

public class KAKAO_2021_2 {
    final int WAITING_ROOM_SIZE = 5;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = isCorrect(places[i]);
        }
        return answer;
    }

    public int isCorrect(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'P') {
                    if (!bfs(board, i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    private boolean bfs(String[] board, int r, int c) {
        boolean[][] visited = new boolean[5][5];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()) {
            Point current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                int manhattan = Math.abs(r - nextX) + Math.abs(c - nextY);

                if (nextX < 0 || nextY <0 || nextX >= board.length || nextY >= board.length) continue;
                if (visited[nextX][nextY] || manhattan > 2) continue;

                visited[nextX][nextY] = true;
                if (board[nextX].charAt(nextY) == 'X') continue;
                else if (board[nextX].charAt(nextY) == 'P') return false;
                else q.offer(new Point(nextX, nextY));
            }
        }
        return true;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
