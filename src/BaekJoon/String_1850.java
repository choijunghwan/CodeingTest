package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long Gcd = gcd(A, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Gcd; i++) {
            sb.append("1");
        }
        System.out.println(sb.toString());
    }

    private static long gcd(long convertA, long convertB) {
        while (convertB > 0) {
            long temp = convertA % convertB;
            convertA = convertB;
            convertB = temp;
        }

        return convertA;

    }
}
