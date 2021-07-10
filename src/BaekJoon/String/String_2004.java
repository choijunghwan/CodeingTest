package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 범위가 int형을 벗어나기 때문에 long 타입을 사용
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        // nCm 인 조합을 구하는 문제
        // nCm = n! / m! * (n - m)!
        // 0의 개수를 구하기 위해 n! 의 0의 개수에서 - (m! 의 갯수 + (n - m)!의 갯수)
        // 0의 개수를 구할려면 2와 5의 곱으로 이루어진 쌍의 갯수를 세어야 하는데
        // 무조건 5의 개수보다 2의 개수가 많으므로
        // 소인수분해 해서 5의 개수를 세면 그것이 0의 개수와 일치한다.

        long twoCount = twoPowerCnt(n) - twoPowerCnt(n - m) - twoPowerCnt(m);
        long fiveCount = fivePoewCnt(n) - fivePoewCnt(n - m) - fivePoewCnt(m);


        System.out.println(Math.min(twoCount, fiveCount));
    }

    // 소인수 2의 갯수를 구하는 함수
    private static long twoPowerCnt(long num) {
        int count = 0;

        while (num >= 2) {
            count += num / 2;
            num /= 2;
        }

        return count;
    }

    // 소인수 5의 갯수를 구하는 함수
    private static long fivePoewCnt(long num) {
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }

        return count;
    }
}
