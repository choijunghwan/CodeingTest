package DFSBFS;
import java.util.*;

public class BFS {
    public static LinkedList<Integer>[] nodeList;
    public static void main(String[] args) {

    }

    /**
     * BFS는 너비 우선 탐색이다.
     * 같은 레벨의 노드들을 먼저 탐색한다.
     */
    public static void bfs(int node, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);

        while(!queue.isEmpty()){
            node = queue.poll();

            if (visited[node]) continue;

            visited[node] = true;

            for (int nextNode : nodeList[node]) {
                queue.add(nextNode);
            }
        }
    }
}
