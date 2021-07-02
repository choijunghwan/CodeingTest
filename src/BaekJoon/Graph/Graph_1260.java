package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_1260 {
    static int N, M, V;
    static int map[][];
    static ArrayList<TreeMap<Integer, Integer>> arrayList;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        arrayList = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(map[i], 0);
            arrayList.add(new TreeMap<Integer, Integer>());
        }
        Arrays.fill(visit, false);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
            arrayList.get(a).put(b,a);
            arrayList.get(b).put(a, b);
        }
        dfs(V);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(V);
    }

    public static void dfs(int node) {
        visit[node] = true;
        System.out.print(node + " ");

        TreeMap<Integer, Integer> tmp = arrayList.get(node);
        for (int i : tmp.keySet()) {
            if (!visit[i]) dfs(i);
        }

        for (int i = 0; i < N+1; i++) {
            if (map[node][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visit[node] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll + " ");

            for (int i = 0; i < N + 1; i++) {
                if (map[poll][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }

    }
}
