package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph_9466 {
    static boolean[] visited;
    static boolean[] finished;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            arr = new int[n+1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                dfs(j);
            }

            System.out.println(n - count);

        }
    }

    private static void dfs(int num) {
        if (visited[num]) {
            return ;
        }
        visited[num] = true;
        int next = arr[num];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                count++;

                for (int i = next; i != num; i = arr[i]) {
                    count++;
                }
            }
        }

        finished[num] = true;
    }
}
