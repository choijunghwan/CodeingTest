package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] digitCount = new int[10];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            digitCount[ch - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        // 30의 배수를 생성할 수 있는지 판별
        if (!check(digitCount)) {
            sb.append("-1");
        } else {
            sb = createDigit(digitCount);
        }

        System.out.println(sb.toString());
    }

    private static StringBuilder createDigit(int[] digitCount) {
        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {

            while (digitCount[i]-- > 0) {
                sb.append(i);
            }
        }

        return sb;
    }

    private static boolean check(int[] digitCount) {

        if (digitCount[0] == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum += digitCount[i] * i;
        }

        if (sum % 3 == 0) {
            return true;
        }

        return false;
    }
}
