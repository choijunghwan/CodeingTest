package BaekJoon.DC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DC_1780 {
    static int[] paperCnt;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        paperCnt = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 종이가 모두 같은 수로 되어 있는지 확인한다.  9*9를 체크
        // false -> 9개의 종이로 나눈다 ->  3*3 크기로 9개로 나눈다.
        // 3*3 크기 종이을 체크

        // isSameDigit 함수를 통해 모두 같은 수로 되어 있는지 체크
        // -> arr 배열을 넘겨주고, 체크
        recur(0,0,N);

        StringBuilder sb = new StringBuilder();
        sb.append(paperCnt[0] + "\n").append(paperCnt[1] + "\n").append(paperCnt[2]);
        System.out.println(sb.toString());
    }

    private static void recur(int row, int col, int n) {

        if (isSameDigit(row, col, n)) {
            paperCnt[arr[row][col]+1]++;
            return;
        }

        // if 9일때면
        // (0,0)    (0,3)   (0,6)
        // (3,0)    (3,3)   (3,6)
        // (6,0)    (6,3)   (6,6)
        int s = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recur(row + s * i, col + s * j, s);
            }
        }

    }

    private static boolean isSameDigit(int row, int col, int n) {
        if (n == 1) {
            return true;
        }

        int digit = arr[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (arr[i][j] != digit) {
                    return false;
                }
            }
        }

        return true;
    }
}
