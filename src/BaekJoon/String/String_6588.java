package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1000001];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(1000001); i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i*i; j < isPrime.length ; j+=i) {
                isPrime[j] = true;
            }


        }
        String str;
        while (!(str = br.readLine()).equals("0")) {
            int num = Integer.parseInt(str);
            boolean isSumDigit = false;
            for (int i = 3; i <= num/2; i+=2) {
                if (!isPrime[i] && !isPrime[num - i]) {
                    System.out.println(num + " = " + i + " + " + (num - i));
                    isSumDigit = true;
                    break;
                }
            }
            if (!isSumDigit) {
                System.out.println("Goldbach's conjecture is wrong");
            }
        }
    }
}
