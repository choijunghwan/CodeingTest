package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int twoCount = 0;
        int fiveCount = 0;

        // N을 쭉 반복하면서 각 단계마다 2와 5의 곱이 몇번 포함되어 있는지 확인한다.
        for (int i = 2; i <= N; i++) {
            int num = i;
            while (num % 2 == 0) {
                num /= 2;
                twoCount++;
            }
            while (num % 5 == 0) {
                num /= 5;
                fiveCount++;
            }
        }

        int result = Math.min(twoCount, fiveCount);
        System.out.println(result);
    }
}
