package BaekJoon.DC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 패턴이 들어오면 9 구간으로 나눠준다.
 * 2. 가운데 부분만 냅 두고 나머지 8구간은 재귀 반복을 실행한다.
 * 3. 길이가 3이 될 경우
 *    ***
 *    * *
 *    ***
 *    을 찍어낸다.
 */
public class DC_2447 {
    static int[][] maps;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        maps = new int[N][N];

        recur(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i][j] == 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void recur(int x, int y, int len) {

        if (len == 3) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i != 1 || j != 1) {
                        maps[x+i][y+j] = 1;
                    }
                }
            }
            return;
            /*maps[x][y] = 1;
            maps[x][y+1] = 1;
            maps[x][y+2] = 1;
            maps[x+1][y] = 1;
            maps[x+1][y+2] = 1;
            maps[x+2][y] = 1;
            maps[x+2][y+1] = 1;
            maps[x+2][y+2] = 1;*/
        }

        len /= 3;
        recur(x, y, len);
        recur(x, y + len, len);
        recur(x, y + len * 2, len);
        recur(x + len, y, len);
        recur(x + len, y + len * 2, len);
        recur(x + len * 2, y, len);
        recur(x + len * 2, y + len, len);
        recur(x + len * 2, y + len * 2, len);

    }
}
