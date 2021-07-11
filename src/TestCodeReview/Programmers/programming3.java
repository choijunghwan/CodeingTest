package TestCodeReview.Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 요구사항
 * 1. n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있다.
 * 2. 전선들 중 하나를 끊어서 전력망 네트워크를 2개로 분할할려고 한다.
 * 3. 하나를 끊어서 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)을 return해라
 *
 * 제한사항
 * 1. wires의 각 원소는[v1,v2]로 주어지며, v1송전탑과 v2 송전탑이 전선으로 연결되어 있다는 것을 의미한다.
 * 2. 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않는다.
 */
public class programming3 {
    // 인접 배열 대신 인접 리스트를 사용한 이유는
    // 이 문제의경우 각 송전탑에 연결되 송전탑들을 순서대로 조회해서 체크하면 되기 때문에
    // 순서대로 조회에 더 능한 인접 리스트를 사용했다.
    static ArrayList<ArrayList<Integer>> arrayList;
    static final int Max = 101;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
//        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        int result = solution(n, wires);
        System.out.println(result);
    }

    private static int solution(int n, int[][] wires) {
        int answer = Max;
        arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            arrayList.get(wire[0]-1).add(wire[1]);
            arrayList.get(wire[1]-1).add(wire[0]);
        }

        for (int[] wire : wires) {
            boolean[] visited = new boolean[n];
            // v1, v2 연결 끊은것을 v2에 방문했다고 true 표현한다.
            visited[wire[1] -1] = true;
            int count = bfs(wire[0], visited);
            int temp = n - count;
            answer = Math.min(answer, Math.abs(temp - count));
        }
        return answer;

    }

    private static int bfs(int node, boolean[] visited) {
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if (visited[poll - 1]) {
                continue;
            }

            visited[poll - 1] = true;
            cnt++;

            for (int v : arrayList.get(poll - 1)) {
                if (!visited[v -1]) {
                    queue.add(v);
                }
            }
        }

        return cnt;
    }
}
