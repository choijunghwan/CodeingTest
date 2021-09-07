package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        // 최대 백만을 탐색
        boolean[] checked = new boolean[(int) (max - min + 1)];

        long num = 2;
        while (num * num <= max) {
            long pow2Num = num * num;

            long start = min % pow2Num == 0 ? min / pow2Num : (min / pow2Num) + 1;

            while (start * pow2Num <= max) {
                checked[(int) ((start * pow2Num) - min)] = true;
                start++;
            }
            num++;
        }

        int count = 0;
        for (int i = 0; i < checked.length; i++) {
            if (!checked[i]) {
                count++;
            }
        }

        System.out.println(count);

    }
}
