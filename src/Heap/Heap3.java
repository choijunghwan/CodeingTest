package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap3 {
    public static void main(String[] args) {
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};

        PriorityQueue<Integer> priorityQueueWithMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueueWithMin = new PriorityQueue<>();

        for (String operation : operations) {
            String[] splitChar = operation.split(" ");

            if (splitChar[0].equals("I")) {
                priorityQueueWithMax.add(Integer.parseInt(splitChar[1]));
                priorityQueueWithMin.add(Integer.parseInt(splitChar[1]));
            }

            if (splitChar[0].equals("D")) {
                if (!priorityQueueWithMax.isEmpty()) {
                    if (splitChar[1].equals("1")) {
                        int max = priorityQueueWithMax.peek();
                        priorityQueueWithMax.remove(max);
                        priorityQueueWithMin.remove(max);
                    } else {
                        int min = priorityQueueWithMin.peek();
                        priorityQueueWithMin.remove(min);
                        priorityQueueWithMax.remove(min);
                    }
                }
            }

        }

        int[] answer = {0, 0};
        if (!priorityQueueWithMax.isEmpty()) {
            answer[0] = priorityQueueWithMax.peek();
            answer[1] = priorityQueueWithMin.peek();
        }

        System.out.println("answer = " + answer);

    }
}
