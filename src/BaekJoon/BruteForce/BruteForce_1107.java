package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] breakButton = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                breakButton[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min_cnt = Math.abs(N - 100);
        for (int i = 0; i <= 1000000; i++) {
            int len = check(i, breakButton);
            if (len > 0) {
                int press = Math.abs(N - i);
                min_cnt = Math.min(min_cnt, len + press);
            }
        }

        System.out.println(min_cnt);
    }

    private static int check(int n, boolean[] breakButton) {
        if (n == 0) {
            if (breakButton[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (n > 0) {
            if (breakButton[n % 10]) {
                return 0;
            }
            n /= 10;
            len++;
        }

        return len;
    }

}
