package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class String_2089 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while( N < -1 || N > 1){
            if (N > 0) {
                stack.push(N % 2);
                N = (N / 2) * -1;
            }
            if (N < 0) {
                int temp = (N * -1) % 2;
                stack.push(temp);
                N = (N * -1) / 2;
                if (temp == 1) {
                    N += 1;
                }
            }
        }

        if (N != 0) {
            stack.push(N);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (pop == -1) {
                sb.append("11");
            } else {
                sb.append(pop);
            }
        }

        if (N == 0) {
            System.out.println("0");
        } else {
            System.out.println(sb.toString());
        }
    }

}
