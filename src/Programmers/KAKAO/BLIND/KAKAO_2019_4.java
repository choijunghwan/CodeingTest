package Programmers.KAKAO.BLIND;

import java.util.*;

public class KAKAO_2019_4 {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        int k = 5;
        int result = solution(food_times, k);
    }

    public static int solution(int[] food_times, long k) {
        long food_sum = 0;
        for (int i = 0; i < food_times.length; i++) {
            food_sum += food_times[i];
        }

        if (food_sum <= k) {
            return -1;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long total = 0;
        long previous = 0;
        long length = food_times.length;

        while (total + ((pq.peek().time - previous) * length) <= k) {
            int now = pq.poll().time;
            total += (now - previous) * length;
            length--;
            previous = now;
        }

        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.idx, o2.idx);
            }
        });

        return result.get((int) ((k - total) % length)).idx;
    }


    static class Food implements Comparable<Food>{
        int time;
        int idx;

        public Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }


        @Override
        public int compareTo(Food o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
