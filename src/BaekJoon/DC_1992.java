package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 부분 탐색
 * 1. 영역 전체가 0 or 1 로 되어 있는지 체크
 * 2. 안되어 있다면 영역을 4등분한뒤, 각 영역에 대해서 다시 체크
 */
public class DC_1992 {
    static StringBuilder sb;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        quadTree(0, 0, N);

        System.out.println(sb.toString());
    }

    private static void quadTree(int x, int y, int len) {
        // 영역 전체 숫자가 동일 한지 체크
        if (check(x, y, len)) {
            sb.append(map[x][y]);
            return ;
        }

        sb.append("(");
        len = len / 2;
        quadTree(x, y, len);
        quadTree(x, y + len, len);
        quadTree(x + len, y, len);
        quadTree(x+len, y+len, len);

        sb.append(")");
    }

    private static boolean check(int x, int y, int len) {
        if (len == 1) {
            return true;
        }

        int temp = map[x][y];
        for (int i = x; i < x + len ; i++) {
            for (int j = y; j < y + len; j++) {
                if (temp != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
