package Programmers.Greedy;

import java.util.PriorityQueue;

class A implements Comparable<A> {

    int s;
    int e;
    int v;

    public A(int s, int e, int v) {
        super();
        this.s = s;
        this.e = e;
        this.v = v;
    }

    // 오름차순정렬
    // 파라미터로 넘어온 객체 > 현재 객체  -1 반환
    @Override
    public int compareTo(A arg0) {
        return arg0.v >= this.v ? -1 : 1;
    }
}

public class Kruskal {
    public static int find(int a) {
        if (a==parent[a]) return a;  //초기화된 상태(정점이 처음 등장)이면 자기 자신이 부모
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }

    static int N; // 정점의 개수
    static int E; // 간선의 개수
    static PriorityQueue<A> pq; // 간선 값을 Min Programmers.Heap 으로 하는 우선순위 큐
    static int[] parent;  // disjoint-set(union find)에서 필요한 부모 노드를 저장하는 배열
    static boolean[] visit;  // 방문 여부 배열
    static int result; // 결과 값 저장

    public static void main(String[] args) {

        N = 7;
        E = 11;

        parent = new int[N + 1]; //Disjoint-set
        visit = new boolean[N + 1];
        result = 0;

        pq = new PriorityQueue<>();
        pq.add(new A(1, 2, 2));
        pq.add(new A(2, 7, 7));
        pq.add(new A(7, 6, 9));
        pq.add(new A(6, 5, 23));
        pq.add(new A(5, 4, 1));
        pq.add(new A(4, 1, 10));
        pq.add(new A(1, 3, 3));
        pq.add(new A(2, 3, 3));
        pq.add(new A(3, 7, 4));
        pq.add(new A(3, 6, 3));
        pq.add(new A(3, 5, 6));

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            A oneNode = pq.poll();    // 현재 큐에 있는 모든 인스턴스중 비용이 가장 작은 간선이 poll된다
            int start = oneNode.s;
            int end = oneNode.e;
            int a = find(start);      // 만약 이 간선을 선택해서 연결한다고 했을때 사이클이 생기면 안되므로
            int b = find(end);        // 양쪽의 루트(최상위 부모)노드가 무엇인지 확인하고
            if (a == b) continue;     // 만약 같으면 선택하지 않고 넘어간다.

            union(start, end);        // 두개의 루트 노드가 달랐다면 한쪽의 최상의 부모를 다른 한쪽의 부모로 설정
            result += oneNode.v;      // 선택된 간선이므로 간선의 비용을 더한다.
        }
    }
}
