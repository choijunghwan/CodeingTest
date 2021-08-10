package Programmers.Heap;

import java.util.PriorityQueue;

public class Heap1 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        int answer = 0;

        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.peek() >= K) {
                break;
            } else if (priorityQueue.size() == 1) {
                answer = -1;
                break;
            }

            Integer min = priorityQueue.poll();
            Integer secondMin = priorityQueue.poll();
            priorityQueue.add(min + secondMin * 2);

            answer++;
        }

        System.out.println("answer = " + answer);
    }
}
