package Programmers.DFSBFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS {
    public static int nodeCnt;
    public static LinkedList<Integer>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        nodeList = new LinkedList[nodeCnt + 1];

        for(int i = 0; i <= nodeCnt; i++){
            nodeList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < lineCnt; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
        }
    }

    /**
     * DFS(깊이 우선 탐색)
     * 노드들을 탐색할때 먼저 탐색된 노드의 자식노드를 우선적으로 탐색하는것
     * 1. 탐색하려는 노드가 탐색을 이미 한 노드인지 확인
     * 2. 탐색하려는 노드의 자식노드들을 확인
     * 3. 자식노드가 없으면 탐색은 종료되고
     * 4. 자식노드가 있으면 자식노드를 같은 방식으로 탐색한다.
     */
    public static void dfs(int node, boolean[] visited){
        if (visited[node] == true) return;

        visited[node] = true;

        for(int nextNode : nodeList[node]){
        }
    }
}
