package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            count[temp-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(count[i] + " ");
        }
    }
}
