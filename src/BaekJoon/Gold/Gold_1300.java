package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long K = Long.parseLong(br.readLine());

        // 1 ~ N*N
        long min = 1;
        long max = N*N;

        while (min <= max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                if (mid / i >= N) {
                    cnt += N;
                } else {
                    cnt += mid / i;
                }
            }

            if (cnt < K) {
                min = mid + 1;
            } else if (cnt >= K) {
                max = mid - 1;
            }
        }

        System.out.println(min);
    }
}
