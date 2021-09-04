package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold_1005 {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 입력값
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N+1];

            List<List<Integer>> list = new ArrayList<>();
            int[] indegree = new int[N + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                list.add(new ArrayList<>());
            }
            list.add(new ArrayList<>());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list.get(start).add(end);
                indegree[end]++;
            }

            int W = Integer.parseInt(br.readLine());

            // 비즈니스 로직
            BFS(indegree, list, W);

        }
    }

    private static void BFS(int[] indegree, List<List<Integer>> list, int w) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            result[i] = arr[i];

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer i : list.get(node)) {
                result[i] = Math.max(result[i], result[node] + arr[i]);
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(result[w]);
    }

}
