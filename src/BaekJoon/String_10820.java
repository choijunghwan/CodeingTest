package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while ((str = br.readLine()) != null) {
            int lower = 0;
            int upper = 0;
            int num = 0;
            int space = 0;

            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);

                //소문자
                if (temp >= 'a' && temp <= 'z') {
                    lower++;
                }
                //대문자
                if (temp >= 'A' && temp <= 'Z') {
                    upper++;
                }
                //숫자
                if (temp >= '0' && temp <= '9') {
                    num++;
                }
                //공백
                if (temp == ' ') {
                    space++;
                }

            }
            System.out.println(lower + " " + upper + " " + num + " " + space);
        }

    }
}
