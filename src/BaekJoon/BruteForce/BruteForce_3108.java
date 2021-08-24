package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BruteForce_3108 {

    static int N;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        map = new int[N+1][4];

        for (int i = 0; i < 4; i++) {
            map[0][i] = 0;
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = -1;
        for (int i = 0; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int i = 0; i <= N; i++) {
                if (!visited[i]) {

                    //겹치는 부분이 있는지 체크
                    if (isNotDuplicateBoundary(poll, i)) {
                        continue;
                    }

                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static boolean isNotDuplicateBoundary(int num1, int num2) {
        int x1 = map[num1][0];
        int y1 = map[num1][1];
        int x2 = map[num1][2];
        int y2 = map[num1][3];

        int pointX1 = map[num2][0];
        int pointY1 = map[num2][1];
        int pointX2 = map[num2][2];
        int pointY2 = map[num2][3];

        //새로운 직사각형 더 크거나, 겹치는 부분이 없는경우
        // x2 < pointX1 < pointX2 or y2 < pointY1 < pointY2  오른쪽 위 영역
        if (x2 < pointX1 || y2 < pointY1) {
            return true;
        }

        // pointX1 < pointX2 < x1 or pointY1 < pointY2 < y1  왼쪽 아래 영역
        if (pointX2 < x1 || pointY2 < y1) {
            return true;
        }

        // pointX1 < x1 AND x2 < pointX2 AND pointY1 < y1 AND y2 < pointY2
        if (pointX1 < x1 && pointX2 > x2 && pointY1 < y1 && pointY2 > y2) {
            return true;
        }


        //새로운 직사각형이 작아 직사각형 안에 포개질경우
        // x1 < pointX1 < pointX2 < x2 AND y1 < pointY1 < pointY2 < y2
        if (pointX1 > x1 && pointX2 < x2 && pointY1 > y1  && pointY2 < y2) {
            return true;
        }

        return false;
    }
}
