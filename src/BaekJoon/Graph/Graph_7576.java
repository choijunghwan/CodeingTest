package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 순서대로값을 조회하는것이 아닌 인접한 곳 (v1,v2) 에 대한 조회가 빈번히 일어나므로, 인접 리스트 대신 인접 행렬을 사용하여 구현한다.
 * 2. bfs를 응용하여 익은 토마토가 있는 지점들을 queue에 모두 넣고
 * 3. 그 인접한 곳에 있는 익지 않은 토마토를 -> 익은 토마토로 바꾸면서 더이상 queue에 담을 것이 없을 때까지 반복한다.
 * 4. 반복이 끝나면 전체를 살펴서 토마토가 모두 익었는지 확인한다.
 */
public class Graph_7576 {
    static int[][] arr;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int result = bfs();

        if (tomatoCheck()) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }


    }

    private static boolean tomatoCheck() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int bfs() {
        Queue<pos> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new pos(i, j, 0));
                }
            }
        }

        int count = 0;
        int[][] routes = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        while (!queue.isEmpty()) {
            pos temp = queue.poll();

            for (int[] route : routes) {
                int dx = temp.x + route[0];
                int dy = temp.y + route[1];

                if (0 <= dx && dx < N && 0 <= dy && dy < M) {
                    if (arr[dx][dy] == 0) {
                        queue.add(new pos(dx, dy, temp.depth + 1));
                        arr[dx][dy] = 1;
                    }
                }
            }

            count = temp.depth;
        }

        return count;
    }
}

class pos {
    int x;
    int y;
    int depth;

    public pos(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDepth() {
        return depth;
    }
}