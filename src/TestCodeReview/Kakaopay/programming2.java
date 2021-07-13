package TestCodeReview.Kakaopay;

import java.util.Arrays;

/**
 * 이 문제의 핵심은 스와이프를 어떻게 구현하느냐 입니다.
 * 스와이프는 4가지의 경우가 있는데. 저는 각 경우 마다 동작이 다르기 때문에 각각 구현해 주었습니다.
 * 예를 들어 1번 스와이프 행 번호가 증가하는 경우에는
 * 먼저 영역 바깥으로 나가는 숫자들을 임시 배열에 담아놓고, 합을 구해놓았습니다.
 * 그리고 나머지 영역의 숫자를 스와이프하고, 스와이프가 완료된후 남은 빈 공간에는
 * 아까 임시 배열에 담아 놓았던 숫자를 다시 넣어주는 방식을 사용하였습니다.
 *
 */
public class programming2 {
    static int[][] maps;

    public static void main(String[] args) {
        int rows = 4;
        int columns = 3;
        int[][] swipes = {{1, 1, 2, 4, 3,}, {3, 2, 1, 2, 3}, {4, 1, 1, 4, 3}, {2, 2, 1, 3, 3,}};
        int[] result = solution(rows, columns, swipes);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int rows, int columns, int[][] swipes) {
        int[] answer = new int[swipes.length];
        maps = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maps[i][j] = (i * columns) + j + 1;
            }
        }

        for (int i = 0; i < swipes.length; i++) {
            int d = swipes[i][0];
            int sum = 0;

            if (d == 1) {
                sum = swipe1(swipes[i][1] - 1, swipes[i][2] - 1, swipes[i][3] - 1, swipes[i][4] - 1);
            } else if (d == 2) {
                sum = swipe2(swipes[i][1] - 1, swipes[i][2] - 1, swipes[i][3] - 1, swipes[i][4] - 1);
            } else if (d == 3) {
                sum = swipe3(swipes[i][1] - 1, swipes[i][2] - 1, swipes[i][3] - 1, swipes[i][4] - 1);
            } else if (d == 4) {
                sum = swipe4(swipes[i][1] - 1, swipes[i][2] - 1, swipes[i][3] - 1, swipes[i][4] - 1);
            }

            answer[i] = sum;
        }
        return answer;
    }
    // 열 번호 감소
    private static int swipe4(int r1, int c1, int r2, int c2) {
        // (0,0) ~ (3,2)
        int sum = 0;
        int[] arr = new int[r2 - r1 + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = maps[r1 + i][c1];
            sum += maps[r1 + i][c1];
        }

        for (int i = c1; i < c2; i++) {
            for (int j = r1; j <= r2; j++) {
                maps[j][i] = maps[j][i + 1];
            }
        }

        for (int i = r1; i <= r2; i++) {
            maps[i][c2] = arr[i - r1];
        }

        return sum;
    }

    // 열 번호 증가
    private static int swipe3(int r1, int c1, int r2, int c2) {
        // (1,0) ~ (1,2)
        int sum = 0;
        int[] arr = new int[r2 - r1 + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = maps[r1 + i][c2];
            sum += maps[r1 + i][c2];
        }

        for (int i = c2; i > c1; i--) {
            for (int j = r1; j <= r2; j++) {
                maps[j][i] = maps[j][i - 1];
            }
        }

        for (int i = r1; i <= r2; i++) {
            maps[i][c1] = arr[i - r1];
        }

        return sum;
    }

    // 행 번호 감소
    private static int swipe2(int r1, int c1, int r2, int c2) {
        // (1,0) ~ (2,2)
        int sum = 0;
        int[] arr = new int[c2 - c1 + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = maps[r1][c1 + i];
            sum += maps[r1][c1 + i];
        }

        for (int i = r1; i < r2; i++) {
            for (int j = c1; j <= c2; j++) {
                maps[i][j] = maps[i + 1][j];
            }
        }

        for (int i = c1; i <= c2; i++) {
            maps[r2][i] = arr[i - c1];
        }

        return sum;
    }

    // 행 번호 증가
    private static int swipe1(int r1, int c1, int r2, int c2) {
        // (0,1) ~ (3,2)
        int sum = 0;
        int[] arr = new int[c2 - c1 + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = maps[r2][c1 + i];
            sum += maps[r2][c1 + i];
        }

        for (int i = r2; i > r1; i--) {
            for (int j = c1; j <= c2; j++) {
                maps[i][j] = maps[i - 1][j];
            }
        }

        for (int i = c1; i <= c2; i++) {
            maps[r1][i] = arr[i - c1];
        }

        return sum;
    }

}
