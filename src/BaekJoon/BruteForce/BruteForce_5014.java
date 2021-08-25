package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BruteForce_5014 {

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        visited = new int[F+1];

        int result = bfs(F, S, G, U, D);

        System.out.println(result > 0 ? result-1 : "use the stairs");

    }

    private static int bfs(int max, int start, int end, int up, int down) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int poll = q.poll();

            if (poll == end) {
                return visited[poll];
            }

            int nextUp = poll + up;
            int nextDown = poll - down;

            if (nextUp > 0 && nextUp <= max && visited[nextUp] == 0) {
                q.add(nextUp);
                visited[nextUp] = visited[poll] + 1;
            }

            if (nextDown > 0 && nextDown <= max && visited[nextDown] == 0) {
                q.add(nextDown);
                visited[nextDown] = visited[poll] + 1;
            }
        }

        return 0;
    }
}
