package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_1707 {
    static ArrayList<ArrayList<Integer>> list;
    static final int RED = 1;
    static final int BLUE = -1;
    static int[] visited;
    static boolean checkBipartite;  //이분그래프인지 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            visited = new int[V+1];
            checkBipartite = true;

            for (int j = 0; j < V+1; j++) {
                list.add(new ArrayList<>());
                visited[j] = 0;
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.get(x).add(y);
                list.get(y).add(x);
            }

            for (int j = 1; j < V + 1; j++) {
                if (!checkBipartite)
                    break;

                if (visited[j] == 0) {
                    bfs(j);
                }
            }

            System.out.println(checkBipartite ? "YES" : "NO");
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = RED;

        while (!queue.isEmpty() && checkBipartite) {
            int v = queue.poll();

            for (int adjV : list.get(v)) {
                // 방문하지 않은 정점이라면
                if (visited[adjV] == 0) {
                    queue.add(adjV);
                    visited[adjV] = visited[v] * -1;  // 인접한 정점을 다른색으로
                }
                // 서로 인접한 정점의 색이 같은 색이면 이분 그래프가 아니다
                else if (visited[v] + visited[adjV] != 0) {
                    checkBipartite = false;
                    return;
                }
            }
        }

    }
}
