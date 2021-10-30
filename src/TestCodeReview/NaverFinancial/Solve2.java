package TestCodeReview.NaverFinancial;

public class Solve2 {

    public static void main(String[] args) {
        int n = 5;
        int jump = 3;

        int[] result = solution(n, jump);
    }

    // 오른쪽 = 1, 아래 = 2, 왼쪽 = 3, 위 = 4
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static int[] solution(int n, int jump) {
        int[][] direction = getDirection(n);

        int[][] map = new int[n][n];
        int num = 1;
        int pointX = 0;
        int pointY = 0;
        while (true) {

            map[pointX][pointY] = num;
            if (num == n*n) {
                break;
            }
            num++;

            int step = jump;
            while (step > 0) {
                int direct = direction[pointX][pointY];
                int nextX;
                int nextY;
                if (direct == -1) {
                    nextX = 0;
                    nextY = 0;
                } else {
                    nextX = pointX + dx[direct - 1];
                    nextY = pointY + dy[direct - 1];
                }

                if (map[nextX][nextY] == 0) {
                    step--;
                }
                pointX = nextX;
                pointY = nextY;
            }
        }
        int[] answer = new int[]{pointX, pointY};
        return answer;
    }

    private static int[][] getDirection(int n) {
        int[][] map = new int[n][n];

        int x = 0;
        int y = 0;
        int direct = 0;

        for (int i = 0; i < n*n; i++) {

            // 격자의 중앙부분에 도착지점을 표시
            if (i == n*n - 1) {
                map[x][y] = -1;
                continue;
            }

            int nextX = x + dx[direct];
            int nextY = y + dy[direct];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || map[nextX][nextY] != 0) {
                direct++;
                if (direct == 4) {
                    direct = 0;
                }
                map[x][y] = direct + 1;

                x = x + dx[direct];
                y = y + dy[direct];
            } else {
                map[x][y] = direct + 1;
                x = nextX;
                y = nextY;
            }

        }
        return map;
    }
}
