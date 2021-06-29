package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class String_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 36; i++) {
            if (i < 10) {
                map.put((char) (i + '0'), i);
            } else {
                map.put((char) (i - 10 + 'A'), i);
            }
        }

        int result = 0;
        for (int i = 0; i < N.length(); i++) {
            result += Math.pow(B, N.length() - i - 1) * map.get(N.charAt(i));
        }

        System.out.println(result);


    }
}
