package TestCodeReview.NTech;

import java.util.Stack;

/**
 * 요구사항 정의
 * 1. 대괄호 '[' > 중괄호 '{' > 소괄호 '(' 순으로 입력되어야 한다.
 * 2. 같은 문자가 연속으로 되는 경우는 허용하지 않습니다. ex) {{}}
 * 3. 괄호의 쌍이 맞아야 합니다.
 *
 * 제한사항
 * 1. 비교문 (if, switch) 등을 10개 이하 사용하세요
 *
 * 테스트 케이스
 * 1. 3 + ([ 5 + 1 ])  -> false
 * 2. 3 + [( 3 + 1 ]   -> false
 * 3. 3 + [(3 + 1) + 2 ] -> true
 * 4. 3 + {(3 + 4)}  -> true
 */
public class NTech_code {
    public static class PS {
        char a;
        int b;

        public PS(char a, int b) {
            this.a = a;
            this.b = b;
        }

        public char getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    public static void main(String[] args) {
        String[] Cases = {"3+([5+1])", "3+[(3+1]", "3+[(3+1)+2]", "3+{(3+4)}"};

        for (String aCase : Cases) {
            System.out.println(solution(aCase));
        }
    }

    // 대괄호 -> 3 , 중괄호 -> 2 , 소괄호 -> 1 로 지정하여
    // stack에 들어있는 괄호의 값보다 작을때만 삽입 가능하다.
    private static boolean solution(String aCase) {
        Stack<PS> stack = new Stack<>();

        for (int i = 0; i < aCase.length(); i++) {
            char ch = aCase.charAt(i);
            int num;

            if (stack.isEmpty()) {
                num = 4;
            } else {
                num = stack.peek().getB();
            }

            switch (ch) {
                case '[':
                    if (num < 3) {
                        return false;
                    }
                    stack.push(new PS(ch, 3));
                    break;
                case '{':
                    if (num < 2) {
                        return false;
                    }
                    stack.push(new PS(ch,2));
                    break;
                case '(':
                    if (num < 1) {
                        return false;
                    }
                    stack.push(new PS(ch, 1));
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop().getA() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop().getA() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop().getA() != '[') {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}
