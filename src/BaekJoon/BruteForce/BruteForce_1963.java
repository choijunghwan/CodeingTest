package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BruteForce_1963 {
    static boolean[] primeNum = new boolean[10000];
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 2; i < primeNum.length / 2; i++) {
            if (!primeNum[i]) {
                int temp = i * i;
                while (temp < primeNum.length) {
                    primeNum[temp] = true;
                    temp += i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == B) {
                System.out.println("0");
            } else {
                int result = bfs(A, B);
                System.out.println(result == 0 ? "Impossible" : result - 1);
            }

        }

    }

    private static int bfs(int A, int B) {
        check = new int[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        check[A] = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (poll == B) {
                return check[poll];
            }

            int temp = poll;
            for (int i = 0; i < 4; i++) {
                int digit = temp % 10;
                temp /= 10;

                int index = (int) Math.pow(10, i);
                int num = poll - (digit * index);
                for (int j = 0; j < 10; j++) {
                    if (num >= 1000 && num < 10000 && check[num] == 0 && !primeNum[num]) {
                        check[num] = check[poll] + 1;
                        queue.add(num);
                    }
                    num += index;
                }

            }
        }

        return check[B];
    }
}
