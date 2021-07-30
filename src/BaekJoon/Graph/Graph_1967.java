package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * dfs를 통해 문제를 해결
 * 트리의 지름은 모든 경로중에서 가장 긴 것을 의미한다.
 * 그러므로 1. 루트노드에서 제일 먼 노드를 찾는다.
 *         2. 먼 노드에서 제일 멀리 떨어져 있는 노드를 찾으면 그 둘 사이의 거리가 지름이다.
 *
 */
public class Graph_1967 {
    static List<List<Tree>> list;
    static boolean[] visited;
    static int e;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Tree(b, c));
            list.get(b).add(new Tree(a, c));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        result = 0;
        dfs(e, 0);

        System.out.println(result);

    }

    private static void dfs(int start, int sum) {

        if (result < sum) {
            result = sum;
            e = start;
        }

        visited[start] = true;

        for (Tree t : list.get(start)) {
            if (!visited[t.node]) {
                dfs(t.node, sum + t.len);
            }
        }


    }
}

class Tree {
    int node;
    int len;

    public Tree(int node, int len) {
        this.node = node;
        this.len = len;
    }
}
