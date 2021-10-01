package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_14503 {

    static int N;
    static int M;
    static int[][] maps;

    // d=0 북, d=1 동, d=2 남, d=3 서
    // 왼쪽방향으로 회전
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = robotVaccum(r, c, d);

        System.out.println("result = " + result);
    }

    private static int robotVaccum(int r, int c, int d) {
        int count = 0;

        while (true) {

            // 1. 현재 위치를 청소
            if (maps[r][c] == 0) {
                maps[r][c] = 2;
                count++;
            }

            // 2. 현재 방향을 기준으로 왼쪽 방향부터 탐색
            // d=0 북, d=1 동, d=2 남, d=3 서
            // 현재 자기 d값에서 -1씩 하며 탐색
            boolean check = false;
            int nextD = d - 1;
            for (int i = 0; i < 4; i++) {
                if (nextD < 0) {
                    nextD = 3;
                }
                int nextR = r + dx[nextD];
                int nextC = c + dy[nextD];

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
                    nextD--;
                    continue;
                }

                if (maps[nextR][nextC] != 0) {
                    nextD--;
                    continue;
                }

                check = true;
                r = nextR;
                c = nextC;
                d = nextD;
                break;
            }

            if (!check) {
                int nextR = r + dx[d] * -1;
                int nextC = c + dy[d] * -1;

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || maps[nextR][nextC] == 1) {
                    break;
                }
                r = nextR;
                c = nextC;
            }
        }

        return count;
    }
}
