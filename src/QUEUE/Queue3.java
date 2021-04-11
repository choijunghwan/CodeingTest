package Queue;

import java.util.ArrayList;
import java.util.List;

public class Queue3 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] day = new int[progresses.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            day[i] = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }

        int count = 0;
        int Maxcnt = day[0];
        for (int i = 0; i < day.length; i++) {
            if (Maxcnt >= day[i]) {
                count++;
            } else {
                Maxcnt = day[i];
                list.add(count);
                count = 1;
            }
        }
        list.add(count);

        System.out.println("list = " + list);
        int[] answer = new int[list.size()];
        int size = 0;
        for (Integer i : list) {
            answer[size++] = i;
        }

    }
}
