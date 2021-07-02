package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Graph_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        int P = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        int index = 1;
        map.put(A, index);
        String str = A;
        while (true) {
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                num += Math.pow(Character.getNumericValue(str.charAt(i)), P);
            }

            if (map.containsKey(Integer.toString(num))) {
                System.out.println(map.get(Integer.toString(num)) -1);
                break;
            }
            str = Integer.toString(num);
            map.put(str, ++index);
        }
    }
}
