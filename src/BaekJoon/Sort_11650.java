package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sort_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Edge(x,y));
            arr[i][0] = x;
            arr[i][1] = y;
        }

        //람다식을 이용한 정렬
        //Comparator를 이용한 방법이다.
        Arrays.sort(arr, (e1,e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);

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
