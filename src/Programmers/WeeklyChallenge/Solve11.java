package Programmers.WeeklyChallenge;

import java.util.Stack;

public class Solve11 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        int result = solution(rectangle, characterX, characterY, itemX, itemY);

    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int start_X = characterX * 2;
        int start_Y = characterY * 2;
        int end_X = itemX * 2;
        int end_Y = itemY * 2;

        boolean[][] map = new boolean[102][102];

        for (int[] data : rectangle) {
            for (int i = data[1] * 2; i <= data[3] * 2; i++) {
                for (int j = data[0] * 2; j <= data[2] * 2; j++) {
                    map[i][j] = true;
                }
            }
        }

        for (int[] data : rectangle) {
            for (int i = data[1] * 2 + 1; i <= data[3] * 2 - 1; i++) {
                for (int j = data[0] * 2 + 1; j <= data[2] * 2 - 1; j++) {
                    map[i][j] = false;
                }
            }
        }

        Stack<Point> stack = new Stack<>();
        stack.add(new Point(start_X, start_Y));

        int route = 0;  // 아이템까지의 거리
        int cnt = 0;    // 전체 거리

        while(true) {
            if (stack.isEmpty()) {
                break;
            }
            Point point = stack.pop();

            if (point.x == end_X && point.y == end_Y) {
                route = cnt;
            }

            map[point.y][point.x] = false;

            for (int i = 0; i < 4; i++) {
                int next_X = point.x + dx[i];
                int next_Y = point.y + dy[i];

                if (map[next_Y][next_X]) {
                    stack.add(new Point(next_X, next_Y));
                }
            }

            cnt++;
        }


        int answer = Math.min(route, cnt - route);
        return answer/2;
    }

    static class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
