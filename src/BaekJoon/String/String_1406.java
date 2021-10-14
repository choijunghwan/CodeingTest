package BaekJoon.String;

import java.io.*;
import java.util.*;

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

    /**
     * 삽입,삭제의 효율이 좋은 LinkedList를 사용했지만 시간초과가 났다.
     * 위 문제에서는 커서라는게 존재하므로 list내의 커서를 이동시킬 수 있으면 좋은데
     * iterator()는 한방향으로 반복만 지원한다.
     * 이러한 문제를 해결하기 위해 양방향을 지원하는 listIterator()가 있다.
     */
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        List<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // listIterator 호출
        ListIterator<Character> iter = list.listIterator();

        // 처음 커서를 문장의 맨 뒤로 이동
        while (iter.hasNext()) {
            iter.next();
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch (c) {
                case 'L':
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;

                case 'D':
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;

                case 'B':
                    //remove() 메소드는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;

                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);

                    break;

                default:
                    break;
            }
        }

        for (Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();

    }
}
