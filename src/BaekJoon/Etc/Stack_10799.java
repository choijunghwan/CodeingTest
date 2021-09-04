package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);

            if (temp == '(') {
                stack.add('(');
            } else if (temp == ')') {
                if (str.charAt(i - 1) == ')') {
                    stack.pop();
                    answer++;
                } else {
                    stack.pop();
                    answer += stack.size();
                }
            }
        }

        System.out.println(answer);

    }
}
