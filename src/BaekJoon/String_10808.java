package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 10808, 10809 두 문제 풀이
public class String_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] count = new int[26];
        Arrays.fill(count, -1);

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (count[temp - 'a'] == -1) {
                count[temp - 'a'] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(count[i] + " ");
        }
    }
}
