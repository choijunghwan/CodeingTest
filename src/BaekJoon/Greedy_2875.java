package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 남학생 수와 여학생 수를 비교
 *     1.1 남학생 * 2 < 여학생  이면 여학생 - 1
 *     1.2 남학생 * 2 >= 여학생  이면 남학생 - 1
 */
public class Greedy_2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int countTeam = 0;
        while (K-- > 0) {
            if (M * 2 < N) {   // 남학생 * 2 < 여학생
                N--;
            } else if (M * 2 >= N) { // 남학생 * 2 > 여학생
                M--;
            }
        }

        countTeam = Math.min(N / 2, M);

        if (countTeam < 0) {
            countTeam = 0;
        }
        System.out.println(countTeam);
    }
}
