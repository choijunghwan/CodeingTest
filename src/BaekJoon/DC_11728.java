package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DC_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        int[] arr = new int[N + M];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            queueA.add(Integer.parseInt(st1.nextToken()));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            queueB.add(Integer.parseInt(st2.nextToken()));
        }

        for (int i = 0; i < N + M; i++) {

            if (queueA.isEmpty()) {
                arr[i] = queueB.poll();
                continue;
            } else if (queueB.isEmpty()) {
                arr[i] = queueA.poll();
                continue;
            }

            int pollA = queueA.peek();
            int pollB = queueB.peek();
            if (pollA <= pollB) {
                arr[i] = pollA;
                queueA.poll();
            } else if (pollA > pollB) {
                arr[i] = pollB;
                queueB.poll();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            sb.append(arr[i] + " ");
        }

        System.out.println(sb.toString());



    }
}
