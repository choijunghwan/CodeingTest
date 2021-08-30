package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 소수 = false, 소수x = true
        boolean[] notPrimeNum = new boolean[4000001];
        notPrimeNum[0] = true;
        notPrimeNum[1] = true;
        int size = 0;
        for (int i = 2; i < notPrimeNum.length; i++) {
            if (!notPrimeNum[i]) {
                size++;
                for (int j = i + i; j < notPrimeNum.length; j += i) {
                    notPrimeNum[j] = true;
                }
            }
        }

        int[] prime = new int[size];
        int index = 0;
        for (int i = 2; i < notPrimeNum.length; i++) {
            if (!notPrimeNum[i]) {
                prime[index++] = i;
            }
        }

        int answer = 0;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (true) {

            if (sum < N) {
                sum += prime[end++];
            } else if (end == size) {
                break;
            } else if (sum == N) {
                answer++;
                sum -= prime[start++];
            } else {
                sum -= prime[start++];
            }
        }

        System.out.println(answer);
    }
}
