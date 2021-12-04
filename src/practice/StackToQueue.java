package practice;

import java.util.Stack;

public class StackToQueue {

    /**
     * 2개의 스택으로 큐 구현
     * 1, 2, 3, 4 배열 데이터가 있다고 가정하고 구현
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        StackQueue<Integer> queue = new StackQueue<>();
        for (int i : arr) {
            queue.inPush(i);
        }

        System.out.println("queue.outPop() = " + queue.outPop());
        System.out.println("queue.outPop() = " + queue.outPop());
        System.out.println("queue.outPop() = " + queue.outPop());
        System.out.println("queue.outPop() = " + queue.outPop());

    }

    static class StackQueue<T> {
        private Stack<T> inBox;
        private Stack<T> outBox;

        StackQueue() {
            inBox = new Stack<>();
            outBox = new Stack<>();
        }

        // 데이터가 들어오면 무조건 inBox에 넣어준다.
        void inPush(T item) {
            inBox.push(item);
        }

        // 데이터를 추출하게 되면
        // outBox로 데이터를 옮겨서 값을 하나씩 추출해준다.
        Object outPop() {
            if (outBox.isEmpty()) {
                while (!inBox.isEmpty()) {
                    outBox.push(inBox.pop());
                }
            }
            return outBox.pop();
        }
    }
}
