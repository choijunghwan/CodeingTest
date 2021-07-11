package TestCodeReview.Programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * 요구사항
 * 1. 입금한 금액은 입금 내용마다 나누어서 순서대로 통장에 표시
 * 2. 출금할 때는 가장 마지막 입금한 내용부터 하나씩 삭제하며 출금액을 맞춘다.
 *
 * 제한사항
 * 1. 통장에 입금된 금액보다 큰 금액을 출금하는 경우는 없다.
 * 2. 정담으로 return 하는 배열 길이가 1이상인 경우만 입력으로 주어진다.
 * 3. deposit 원소는 0이 아닌 정수로만 주어진다.
 */
public class programming2 {
    public static void main(String[] args) {
        int[] deposit = {500, 1000, -300, 200, -400, 100, -100};
        int[] result = solution(deposit);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] deposit) {
        // 배열을 이용하면 index를 고려해서 작성해야하지만
        // stack을 이용하면 stack 자료구조의 특성상 가장 최근에 입금한 돈을 바로 꺼낼 수 있기 때문에
        // 돈만 비교해서 작성하면 되고, 속도도 더 빠르므로 stack 자료구조를 선택했다.
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < deposit.length; i++) {
            int money = deposit[i];

            if (money > 0) {  // 입금할 경우
                stack.push(money);
            } else if (money < 0) { // 출금할 경우
                // 항상 입금 금액 > 출금 금액 보다 크므로, isEmpty 예외처리는 생략

                money += stack.pop();
                while (money < 0) {
                    money += stack.pop();
                }

                if (money != 0) {
                    stack.push(money);
                }
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
