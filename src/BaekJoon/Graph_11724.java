package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_11724 {
    static int N, M;
    static int[] parent;
    static int [][] graph;
    static boolean[] visit;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        graph = new int[N+1][N+1];
        visit = new boolean[N+1];
        adjList = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
            graph[a][b] = 1;
            graph[b][a] = 1;
            adjList[a].add(b);
            adjList[b].add(a);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < N+1; i++) {
            set.add(find(i));
        }
        System.out.println(set.size());

        int ans = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                bfs(i);
                ans++;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                ans++;
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visit[node] = true;

        while (!queue.isEmpty()){
            int poll = queue.poll();

            for (int i = 0; i < N + 1; i++) {
                if (graph[node][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    private static void dfs(int node) {
        if (visit[node]) return;
        visit[node] = true;

        for (int i : adjList[node]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }

    public static int find(int a){
        if (a == parent[a]) return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if (x == y) return;
        else parent[y] = x;
    }

}
