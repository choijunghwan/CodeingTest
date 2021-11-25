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

        void inPush(T item) {
            if (inBox.isEmpty()) {
                inBox.push(item);
            } else {
                while (!inBox.isEmpty()) {
                    outBox.push(inBox.pop());
                }

                inBox.push(item);

                while (!outBox.isEmpty()) {
                    inBox.push(outBox.pop());
                }
            }
        }

        Object outPop() {
            return inBox.pop();
        }
    }
}
