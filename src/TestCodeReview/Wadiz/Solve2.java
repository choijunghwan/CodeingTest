package TestCodeReview.Wadiz;

import java.util.*;

public class Solve2 {
    public static void main(String[] args) {
        String[] code = {"a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a",
                ".......print b", "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a" };
        String[] result = solution(code);
        System.out.println(Arrays.toString(result));

    }

    static Map<Character, Stack<Param>> map;
    static List<String> result;
    public static String[] solution(String[] code) {
        map = new HashMap<>();
        result = new LinkedList<>();
        for (String c : code) {
            int len = c.length();
            c = c.replace(".", "");
            int dotCount = len - c.length();

            if (c.contains("=")) {
                addParam(c,dotCount);
            } else {
                printParam(c,dotCount);
            }
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private static void printParam(String c, int dotCount) {
        String[] str = c.split(" ");
        char ch = str[1].charAt(0);

        // 변수가 없는경우
        if (!map.containsKey(ch)) {
            result.add("error");
            return;
        }

        // 변수가 있는 경우
        Stack<Param> stack = map.get(ch);

        while (!stack.isEmpty()) {
            Param p = stack.peek();

            // 바로 출력가능하면 반복문 종료
            if (p.index <= dotCount) {
                break;
            }

            stack.pop();
        }

        if (stack.isEmpty()) {
            result.add("error");
        } else {
            result.add(ch + "=" + stack.peek().num);
        }
    }

    private static void addParam(String c, int dotCount) {
        String[] str = c.split("=");

        char ch = str[0].charAt(0);

        // 처음이면
        if (!map.containsKey(ch)) {
            Param param = new Param(Integer.parseInt(str[1]), dotCount);
            map.put(ch, new Stack<>());
            map.get(ch).add(param);
            return;
        }

        // 이미 있는경우
        Stack<Param> stack = map.get(ch);
        while (!stack.isEmpty()) {
            Param p = stack.peek();

            if (p.index <= dotCount) {
                break;
            }

            stack.pop();
        }
        stack.add(new Param(Integer.parseInt(str[1]), dotCount));
    }
}

class Param {
    int num;    // 변수 값
    int index;  // 점의 갯수

    public Param(int num, int index) {
        this.num = num;
        this.index = index;
    }
}