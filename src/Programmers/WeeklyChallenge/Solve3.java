package Programmers.WeeklyChallenge;

import java.util.*;

public class Solve3 {
    public static void main(String[] args) {

        int[][] game_board = {{1,1,0,0,1,0},
                {0,0,1,0,1,0},
                {0,1,1,0,0,1},
                {1,1,0,1,1,1},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0}
        };

        int[][] table = {{1,0,0,1,1,0},
                {1,0,1,0,1,0},
                {0,1,1,0,1,1},
                {0,0,1,0,0,0},
                {1,1,0,1,1,0},
                {0,1,0,0,0,0}
        };

        /*int[][] game_board = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        int[][] table = {{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};*/

        int result = solution(game_board, table);
        System.out.println("result = " + result);
    }

    static ArrayList<String> emptyList = new ArrayList<>();
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    private static int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 0) {
                    emptyList.add(bfs(game_board, i, j, 0));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1) {
                    answer += find(bfs(table, i, j, 1));
                }
            }
        }

        return answer;
    }

    private static int find(String s) {
        int point = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                point++;
            }
        }

        for (int i = 0; i < emptyList.size(); i++) {
            String str = emptyList.get(i);

            for (int j = 0; j < 4; j++) {
                str = rotate(str);

                if (s.equals(str)) {
                    emptyList.remove(i);
                    return point;
                }
            }
        }

        return 0;
    }

    private static String rotate(String s) {
        String str = "";
        int x = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            if (x == 0) {
                if (s.charAt(i) != ' ') {
                    y++;
                }
            }
            if (s.charAt(i) == ' ') {
                x++;
            }
        }

        char[][] arr = new char[x][y];
        StringTokenizer st = new StringTokenizer(s);

        for (int i = 0; i < x; i++) {
            arr[i] = st.nextToken().toCharArray();
        }

        for (int j = 0; j < y; j++) {
            for (int i = x - 1; i >= 0; i--) {
                str += arr[i][j];
            }
            str += " ";
        }

        return str;
    }

    private static String bfs(int[][] arr, int i, int j, int mode) {
        // mode 0 : game_board, mode 1 : table
        String s = "";
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visitied = new boolean[N][N];

        int x_min = i;
        int x_max = i;
        int y_min = j;
        int y_max = j;

        visitied[i][j] = true;
        arr[i][j] = (mode + 1) % 2;
        queue.add(new Point(i, j));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            x_min = Math.min(x_min, x);
            x_max = Math.max(x_max, x);
            y_min = Math.min(y_min, y);
            y_max = Math.max(y_max, y);

            for (int k = 0; k < 4; k++) {
                int nextX = x + dx[k];
                int nextY = y + dy[k];

                if (!isBoundary(nextX, nextY)){
                    continue;
                }

                if (arr[nextX][nextY] == mode && !visitied[nextX][nextY]) {
                    visitied[nextX][nextY] = true;
                    arr[nextX][nextY] = (mode + 1) % 2;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }

        for (int x = x_min; x <= x_max; x++) {
            for (int y = y_min; y <= y_max; y++) {
                s += visitied[x][y] ? "1" : "0";
            }
            s += " ";
        }

        return s;
    }

    private static boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
