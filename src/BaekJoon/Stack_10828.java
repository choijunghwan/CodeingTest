package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[10001];
        int index = -1;

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");

            if (str[0].equals("push")) {
                index++;
                stack[index] = Integer.parseInt(str[1]);
            } else if (str[0].equals("pop")) {
                if (index < 0) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack[index]);
                    index--;
                }
            } else if (str[0].equals("size")) {
                if (index < 0) {
                    System.out.println("0");
                } else {
                    System.out.println(index+1);
                }
            } else if (str[0].equals("empty")) {
                if (index < 0) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (str[0].equals("top")) {
                if (index < 0) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack[index]);
                }
            }
        }
    }
}
