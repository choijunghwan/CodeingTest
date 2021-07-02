package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_10451 {
    static int[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            graph = new int[N];
            visited = new boolean[N];
            int count = 0;

            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[j] = Integer.parseInt(str[j]);
            }

            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    continue;
                }

                bfs(j);
                count++;
            }

            System.out.println(count);

        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            int next = graph[poll];

            // 방문했었다면, 사이클이 생성된거니 종료
            if (visited[next-1]) {
                return ;
            }

            visited[next-1] = true;
            queue.add(next-1);
        }
    }
}
