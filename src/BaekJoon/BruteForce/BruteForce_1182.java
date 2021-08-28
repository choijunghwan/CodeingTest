package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_1182 {

    static int[] arr;
    static boolean[] visited;
    static int N;
    static int S;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N];
            DFS(0, 0, i);
        }

        System.out.println(ans);
    }

    private static void DFS(int start, int depth, int count) {

        if (depth == count) {
            checkSum();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            DFS(i+1, depth + 1, count);
            visited[i]= false;
        }
    }

    private static void checkSum() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }

        if (sum == S) {
            ans++;
        }
    }
}
