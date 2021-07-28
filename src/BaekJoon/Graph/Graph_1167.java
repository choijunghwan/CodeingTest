package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * dfs를 통해 트리를 탐색해서 최대거리를 찾는다.
 */
public class Graph_1167 {
    static List<List<treeGraph>> list;
    static boolean[] visited;
    static int answer = 0;
    static int e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[V];

        for (int i = 0; i <= V + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int root = Integer.parseInt(st.nextToken());
            while (true) {
                int A = Integer.parseInt(st.nextToken());
                if (A == -1) {
                    break;
                }
                int B = Integer.parseInt(st.nextToken());

                list.get(root).add(new treeGraph(A, B));
            }
        }

        dfs(1, 0);

        visited = new boolean[V];
        dfs(e, 0);
        System.out.println(answer);

    }

    private static void dfs(int start, int sum) {
        if (sum > answer) {
            answer = sum;
            e = start;
        }
        visited[start - 1] = true;

        for (treeGraph tg : list.get(start)) {
            if (!visited[tg.node -1]) {
                dfs(tg.node, sum + tg.distance);
            }
        }

    }
}

class treeGraph {
    int node;
    int distance;

    treeGraph(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
