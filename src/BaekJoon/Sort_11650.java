package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sort_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Edge(x,y));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            System.out.println(edge.x + " " + edge.y);
        }

    }

    public static class Edge implements Comparable<Edge> {
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.x < o.x) {
                return -1;
            } else if (this.x == o.x){
                return this.y < o.y ? -1 : 1;
            } else {
                return 1;
            }
        }
    }

}
