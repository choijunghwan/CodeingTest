package TestCodeReview.woowahan;

public class Solve5 {
    public int[][] solution(int rows, int columns) {
        // row 랑 columns이 같으면 무한루프
        int[][] map = new int[rows][columns];
        int zeroCnt = rows * columns;
        int num = 1;  // 현재 입력할 숫자
        int r = 0;
        int c = 0;

        while (zeroCnt > 0) {

            // rows랑 columns가 같으면 한바퀴 돌고나서 정지
            if (rows == columns && num > rows * 2) {
                break;
            }

            if (map[r][c] == 0) {
                zeroCnt--;
            }
            map[r][c] = num++;

            boolean isEven = isCheckEven(num - 1);

            if (isEven) {
                r = r + 1;
                if (r == rows) {
                    r = 0;
                }
            } else {
                c = c + 1;
                if (c == columns) {
                    c = 0;
                }
            }
        }

        return map;
    }

    private boolean isCheckEven (int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
}
