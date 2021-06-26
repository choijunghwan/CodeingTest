package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int d = gcd(x, y);  // 최대공약수_재귀
        int g = GCD(x, y);  // 최대공약수_반복문
        System.out.println(d);
        System.out.println(x * y / d);
    }

    // 최대공약수 반복문 방식
    public static int GCD(int x, int y) {

        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }

        return x;
    }

    // 최대공약수 재귀 방식
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        // GCD(a,b) = GCD(b,r) 이므로 (r = a % b)
        return gcd(y, x % y);
    }
}
