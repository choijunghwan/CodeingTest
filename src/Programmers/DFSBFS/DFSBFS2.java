package Programmers.DFSBFS;

/**
 * DFS로 노드를 탐색하면서 연결된 곳을 쭉 탐색하고
 * 방문안했던 노드가 존재하면 또 다른 네트워크가 추가 된다는 것을 알 수 있기에 네트워크 수 +1 을 해준다.
 * 그리고 그 이후로 false부터 다시 노드를 탐색한다.
 */
public class DFSBFS2 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = 0;

        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false) {
                answer++;
                dfs(i, visited, computers);
            }
        }

        System.out.println("answer = " + answer);


    }

    static void dfs(int node, boolean[] visited, int[][] computers) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[node][i] == 1) {
                dfs(i, visited, computers);
            }
        }

    }
}
