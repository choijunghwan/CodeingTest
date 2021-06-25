package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arrCh = br.readLine().toCharArray();

        for (int i = 0; i < arrCh.length; i++) {
            if (arrCh[i] >= 'a' && arrCh[i] <= 'z') {
                char ch = (char)(arrCh[i] + 13);
                if (ch > 'z') {
                    ch -= 26;
                }
                arrCh[i] = ch;
            } else if (arrCh[i] >= 'A' && arrCh[i] <= 'Z') {
                char ch = (char)(arrCh[i] + 13);
                if (ch > 'Z') {
                    ch -= 26;
                }
                arrCh[i] = ch;
            }
        }

        String result = String.valueOf(arrCh);
        System.out.println(result);
    }
}
