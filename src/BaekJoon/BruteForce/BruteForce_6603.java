package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_6603 {

    public static final int MAX_LENGTH = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());

            if (K == 0) {
                break;
            }

            int[] arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] output = new int[6];
            StringBuilder sb = new StringBuilder();
            comb(arr, output, 0, 0, sb);

            System.out.println(sb.toString());
        }
    }

    private static void comb(int[] arr, int[] output, int start, int depth, StringBuilder sb) {

        if (depth == MAX_LENGTH) {
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            output[depth] = arr[i];
            comb(arr, output, i + 1, depth + 1, sb);
        }
    }
}
