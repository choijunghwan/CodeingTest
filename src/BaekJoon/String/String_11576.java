package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class String_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for (int i = 1; i <= m; i++) {
            int digit = Integer.parseInt(st.nextToken());
            sum += Math.pow(A, m - i) * digit;
        }

        Stack<Integer> stack = new Stack<>();
        while (sum > 0) {
            stack.push(sum % B);
            sum /= B;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
