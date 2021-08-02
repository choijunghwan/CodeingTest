package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());  //세로
        long M = Long.parseLong(st.nextToken());  //가로

        long result = 0L;

        if (N == 1) {
            result = 1L;
        } else if (N == 2) {
            result = Math.min(4, (M + 1) / 2);
        } else if (N >= 3) {
            if (M < 7) {
                result = Math.min(4, M);
            } else {
                result = M - 7 + 5;
            }
        }

        System.out.println(result);
    }
}
