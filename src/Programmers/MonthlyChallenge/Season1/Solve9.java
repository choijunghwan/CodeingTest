package Programmers.MonthlyChallenge.Season1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solve9 {

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}};
        int result = solution(n, edges);
        System.out.println("result = " + result);
    }
    public static int solution(int n, int[][] edges) {
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        // 임의의 점 1에서 가장 먼 노트 X를 찾음
        int start = 1;
        int[] result = bfs(list, start, n);
        for (int i = 2; i <= n; i++) {
            if (result[i] > result[start]) start = i;
        }

        // X에서 각 노드까지의 값을 찾음
        int cnt = 0;
        result = bfs(list, start, n);
        for (int i = 1; i <= n; i++) {
            if (result[i] > result[start]) start = i;
        }
        for (int i = 1; i <= n; i++) {
            if (result[start] == result[i]) cnt++;
        }
        if (cnt >= 2) {
            return result[start];
        }

        cnt = 0;
        result = bfs(list, start, n);
        for (int i = 1; i <= n; i++) {
            if (result[i] > result[start]) start = i;
        }
        for (int i = 1; i <= n; i++) {
            if (result[start] == result[i]) cnt++;
        }
        if (cnt >= 2) return result[start];
        return result[start] - 1;
    }

    private static int[] bfs(List<Integer>[] list, int start, int n) {
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : list[now]) {
                if (visit[i]) continue;
                visit[i] = true;
                queue.add(i);
                dist[i] = dist[now] + 1;
            }
        }

        return dist;
    }


}
