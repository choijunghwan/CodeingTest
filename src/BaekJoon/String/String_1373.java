package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N.length(); i++) {
            if (i == 0 && N.length() % 3 != 0) {
                int range = N.length() % 3;
                sb.append(convert(N.substring(0, range)));
                i += range - 1;
            } else {
                sb.append(convert(N.substring(i, i + 3)));
                i += 2;
            }
        }

        System.out.println(sb.toString());
    }

    private static String convert(String str) {
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '1') {
                temp += Math.pow(2, str.length() - i - 1);
            }
        }
        return Integer.toString(temp);
    }
}
