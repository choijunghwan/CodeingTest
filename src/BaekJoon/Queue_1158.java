package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        System.out.print("<");
        while (!queue.isEmpty()) {

            for (int i = 1; i < K; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            System.out.print(queue.poll());
            if (queue.size() != 0) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
