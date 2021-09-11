package TestCodeReview.Kakao;



public class Solve6 {

    public int solutionV(int[][] board, int[][] skill) {
        row = board.length;
        col = board[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = board[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + board[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i -1][j] + dp[i][j-1] - dp[i-1][j-1] + board[i][j];
            }
        }

        return 0;
    }
    /**
     * 2차원 -> 1차원 배열
     */
    int row;
    int col;
    public int solutionV2(int[][] board, int[][] skill) {
        row = board.length;
        col = board[0].length;

        int[] map = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i * col + j] = board[i][j];
            }
        }

        for (int[] cmd : skill) {
            if (cmd[0] == 1) {
                gameV2(map, cmd[1], cmd[2], cmd[3], cmd[4], cmd[5] * -1);
            } else if (cmd[0] == 2) {
                gameV2(map, cmd[1], cmd[2], cmd[3], cmd[4], cmd[5]);
            }
        }

        int answer = getBuildCntV2(map);
        return answer;
    }

    private int getBuildCntV2(int[] map) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                count++;
            }
        }
        return count;
    }
    private void gameV2(int[] map, int r1, int c1, int r2, int c2, int degree) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                map[i * col + j] += degree;
            }
        }
    }

    /**
     * 정확도 버전(2차원 배열 그대로 계산)
     */
    public int solutionV1(int[][] board, int[][] skill) {

        for (int[] cmd : skill) {
            if (cmd[0] == 1) {
                gameV1(board, cmd[1], cmd[2], cmd[3], cmd[4], cmd[5] * -1);
            } else if (cmd[0] == 2) {
                gameV1(board, cmd[1], cmd[2], cmd[3], cmd[4], cmd[5]);
            }
        }

        int answer = getBuildCntV1(board);
        return answer;
    }

    private int getBuildCntV1(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
    private void gameV1(int[][] board, int r1, int c1, int r2, int c2, int degree) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i][j] += degree;
            }
        }
    }
}
