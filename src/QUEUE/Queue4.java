package QUEUE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Queue4 {


    static class priority {
        int document;
        int location;

        public priority(int document, int location) {
            this.document = document;
            this.location = location;
        }

    }

    public int solution(int[] priorities, int location) {
        List<priority> list = new ArrayList<>();
        Queue<priority> queue = new LinkedList<>();
        int[] seq = new int[priorities.length];

        for (int i = 0; i < priorities.length; i++) {
            list.add(new priority(priorities[i], i));
            seq[i] = 0;
        }

        for (priority l : list) {
            queue.offer(l);
        }

        int count = 1;
        while (!queue.isEmpty()) {
            priority poll = queue.poll();
            int maxcnt = poll.document;
            boolean check = true;

            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] > maxcnt && seq[i] == 0) {
                    queue.offer(poll);
                    check = false;
                    break;
                }
            }

            if (check) {
                seq[poll.location] = count;
                count++;
            }


        }

        return seq[location];
    }


}
