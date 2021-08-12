package Programmers.MonthlyChallenge.Season1;

public class Solve4 {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[][] route = {{1,0}, {0,1}, {-1,-1}};
        int[] answer = new int[n*(n+1) / 2];

        arr[0][0] = 1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            int dx = route[i%3][0];
            int dy = route[i%3][1];

            while (true) {
                int nextX = x + dx;
                int nextY = y + dy;

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    break;
                }

                if(arr[nextX][nextY] != 0) {
                    break;
                }

                arr[nextX][nextY] = arr[x][y] + 1;
                x = nextX;
                y = nextY;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[cnt++] = arr[i][j];
            }
        }
        return answer;
    }
}
