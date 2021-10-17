package Programmers.KAKAO.intern;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KAKAO_2021_4 {

    private final static int MAX_N = 1001;
    private final static int INF = Integer.MAX_VALUE;

    int[][] Graph = new int[MAX_N][MAX_N];

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) Graph[i][j] = 0;
                else Graph[i][j] = INF;
            }
        }

        for (int[] data : roads) {
            int u = data[0];
            int v = data[1];
            int w = data[2];
            if (w < Graph[u][v]) {
                Graph[u][v] = w;
            }
        }

        return dijkstra(n, start, end, traps);
    }

    int dijkstra(int n, int src, int dst, int[] traps) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[MAX_N][1 << 10];
        pq.add(new int[]{0, src, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w = curr[0];
            int u = curr[1];
            int state = curr[2];

            if (u == dst) return w;

            if (visited[u][state]) continue;
            visited[u][state] = true;

            boolean currTrapped = false;
            Map<Integer, Boolean> trapped = new HashMap<>();
            for (int i = 0; i < traps.length; i++) {
                int bit = 1 << i;
                if ( (state & bit) != 0) {
                    if (traps[i] == u) {
                        state &= ~bit;
                    } else {
                        trapped.put(traps[i], true);
                    }
                } else {
                    if (traps[i] == u) {
                        state |= bit;
                        trapped.put(traps[i], true);
                        currTrapped = true;
                    }
                }
            }

            for (int v = 1; v <= n; v++) {
                if (v == u) continue;
                boolean nextTrapped = trapped.containsKey(v) ? true : false;
                if (currTrapped == nextTrapped) {
                    if (Graph[u][v] != INF) {
                        pq.add(new int[]{w + Graph[u][v], v, state});
                    }
                } else {
                    if (Graph[v][u] != INF) {
                        pq.add(new int[]{w + Graph[v][u], v, state});
                    }
                }
            }
        }
        return INF;
    }
}
