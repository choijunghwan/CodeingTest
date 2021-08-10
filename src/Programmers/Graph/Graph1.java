package Programmers.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        int answer = solution(n, edge);
        System.out.println("answer = " + answer);
    }

    public static int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n+1];
        int[] count = new int[n+1];
        bfs(edge, visited, count);
        int max = 0;
        int answer = 0;
        for (int cnt : count) {
            if (max < cnt) {
                max = cnt;
                answer = 1;
            } else if (max == cnt) answer++;
        }

        return answer;
    }

    static class A {
        int node;
        int depth;

        public A(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static void bfs(int[][] edge, boolean[] visited, int[] count) {
        Queue<A> queue = new LinkedList<>();
        queue.add(new A(1,0));
        visited[0] = true;

        while(!queue.isEmpty()) {
            A poll = queue.poll();
            if (visited[poll.node]) {
                continue;
            }
            count[poll.node] = poll.depth;
            visited[poll.node] = true;

            for (int i = 0; i < edge.length; i++){
                if (edge[i][0] == poll.node) {
                    queue.add(new A(edge[i][1], poll.depth + 1));
                } else if (edge[i][1] == poll.node) {
                    queue.add(new A(edge[i][0], poll.depth + 1));
                }
            }

        }

    }
}
