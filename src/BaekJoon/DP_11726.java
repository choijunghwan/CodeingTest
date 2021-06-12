package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        /**
         * 2*1  1개
         * 2*2  2개
         * 2*3  2*1 + 2*2
         * 2*4  2*3 + 2*2
         * 5    4 + 3
         */

        int[] count = new int[num+1];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;


        for (int i = 3; i <= num + 1; i++) {
            count[i] = (count[i - 2] + count[i - 1]) % 10007;
        }


        System.out.println(count[num]);
        br.close();
    }
}
