package BaekJoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 처음에는 ArrayList 를 사용하였지만 시간초과가 발생했다.
 * 삽입, 삭제가 빈번할때는 ArrayList보다 LinkedList가 효율이 좋아
 * ArrayList -> LinkedList로 변경해보앗지만 시간초과가 발생했다.
 *
 * Stack을 두개 선언해 문제를 해결했다.
 * Stack은 모든 연산이 O(1)의 시간 복잡도를 가지기 때문에 시간 초과에 걸리지 않는다.
 */
public class String_1406 {
    static Stack<String> leftSt;
    static Stack<String> rightSt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        int M = Integer.parseInt(br.readLine());
        leftSt = new Stack<>();
        rightSt = new Stack<>();

        for (String s : str) {
            leftSt.push(s);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("P")) {
                P(st.nextToken());
            } else if (command.equals("L")) {
                L();
            } else if (command.equals("D")) {
                D();
            } else if (command.equals("B")) {
                B();
            }

        }

        while (!leftSt.isEmpty()) {
            rightSt.push(leftSt.pop());
        }
        while (!rightSt.isEmpty()) {
            bw.write(rightSt.pop());
        }
        bw.flush();
        bw.close();
    }

    private static void P(String s) {
        leftSt.push(s);
    }


    private static void B() {
        if (!leftSt.isEmpty()) {
            leftSt.pop();
        }
    }

    private static void D() {
        if (!rightSt.isEmpty()) {
            leftSt.push(rightSt.pop());
        }
    }

    private static void L() {
        if (!leftSt.isEmpty()) {
            rightSt.push(leftSt.pop());
        }
    }
}
