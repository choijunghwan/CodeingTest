package Greedy;

import java.util.*;

class B implements Comparable<B>{
    int s;
    int e;
    int v;

    public B(int s, int e, int v){
        super();
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(B arg0) {
        return arg0.v > this.v ? -1 : 1;
    }
}

public class Greedy5 {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        int answer = solution(n, costs);
        System.out.println("answer = " + answer);
    }

    static int[] parent;

    public static int solution(int n, int[][] costs) {
        int E = costs.length;
        parent = new int[n+1];
        int answer = 0;
        PriorityQueue<B> pq = new PriorityQueue<>();
        for(int[] cost : costs){
            pq.add(new B(cost[0], cost[1], cost[2]));
        }

        for(int i = 1; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < E; i++){
            B oneNode = pq.poll();
            int first = oneNode.s;
            int end = oneNode.e;
            int a = find(first);
            int b = find(end);
            if(a == b) continue;

            union(first, end);
            answer += oneNode.v;
        }

        return answer;
    }

    public static int find(int a){
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot){
            parent[aRoot] = bRoot;
        }

    }
}
