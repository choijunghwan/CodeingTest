package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class String_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        String[] arr = new String[length];

        for (int i = 0; i < length; i++) {
            arr[i] = str.substring(i,length);
        }
        Arrays.sort(arr);

        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }
}
