package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_11725_bfs {
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            list.get(left).add(right);
            list.get(right).add(left);
        }

        int[] parents = new int[N + 1];
        bfs(1, parents, N);

        // 결과 출력
        printParents(parents);

    }

    private static void printParents(int[] parents) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parents.length; i++) {
            sb.append(parents[i] + System.lineSeparator());
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int start, int[] parents, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parents[start] = 1;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int item : list.get(parent)) {
                if (parents[item] == 0) {
                    parents[item] = parent;
                    queue.offer(item);
                }
            }
        }
    }
}
