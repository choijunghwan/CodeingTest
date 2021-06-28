package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] arr = br.readLine().split(" ");
            long sum = 0;
            for (int j = 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (j != k) {
                        sum += Gcd(Integer.parseInt(arr[j]), Integer.parseInt(arr[k]));
                    }
                }
            }


            System.out.println(sum);
        }
    }

    private static int Gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Gcd(b, a % b);
    }
}
