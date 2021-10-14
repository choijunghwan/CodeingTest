package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedList는 삭제, 삽입 성능이 좋으므로 LinkedList로 구현한다.
 * listIterator 사용
 * iterator는 단방향으로만 반복가능하지만 listIterator는 양방향으로 반복이 가능하다.
 */
public class String_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                }
                else if (ch == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                }
                else if (ch == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                }
                else {
                    iter.add(ch);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
