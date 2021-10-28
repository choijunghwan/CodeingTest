package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold_3190 {

    /**
     * 사과가 있는 곳은 2, 뱀이 있는 곳은 1, 나머지는 0
     * 뱀의 머리와 꼬리의 좌표를 저장해두고 갱신한다.
     * 방향 : 오 아래 왼 위 {(0,1), (1,0), (0,-1), (-1,0)}
     * D가 나오면 인덱스를 +1, L이 나오면 인덱스를 -1
     */

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int N, L, K;
    private static int[][] map;
    private static List<int[]> snake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        int[][] dir = new int[L][2];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            dir[i][0] = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            dir[i][1] = str.equals("L") ? -1 : 1;  // L -> -1, D -> 1
        }

        int time = solution(0, 0, 0, dir);
        System.out.println(time);
    }

    private static int solution(int curX, int curY, int currentDir, int[][] dir) {
        int time = 0;
        int turn = 0;

        while (true) {
            time++;
            int nextX = curX + dx[currentDir];
            int nextY = curY + dy[currentDir];

            if (isFinish(nextX, nextY)) break;

            if (map[nextX][nextY] == 1) {
                map[nextX][nextY] = 0;
                snake.add(new int[]{nextX, nextY});
            } else {
                snake.add(new int[]{nextX, nextY});
                snake.remove(0); // 꼬리 제거
            }

            curX = nextX;
            curY = nextY;

            if (turn < L) {
                if (time == dir[turn][0]) {
                    currentDir = nextDir(currentDir, dir[turn][1]);
                    turn++;
                }
            }
        }
        return time;
    }

    private static boolean isFinish(int x, int y) {
        if (x == -1 || x == N || y == -1 || y == N) {
            return true;
        }
        for (int i = 0; i < snake.size(); i++) {
            int[] s = snake.get(i);
            if (s[0] == x && s[1] == y) {
                return true;
            }
        }
        return false;
    }

    private static int nextDir(int current, int dir) {
        int next = (current + dir) % 4;
        if (next == -1) {
            next = 3;
        }
        return next;
    }


}
