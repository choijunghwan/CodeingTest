package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap2 {
    class Jobs implements Comparable<Jobs>{
        int enterT;
        int workT;

        public Jobs(int enterT, int workT) {
            this.enterT = enterT;
            this.workT = workT;
        }

        @Override
        public int compareTo(Jobs o) {
            return this.workT - o.workT;
        }

        @Override
        public String toString() {
            return "workT :" + workT + ", enterT : " + enterT;
        }
    }
    public int solution(int[][] jobs) {

        /**
         * 현재 시점에서 작업시간 제일 작은것들 부터 요청을 처리한다.
         *
         * jobs에 있는 데이터를 우선순위 큐에 저장 -> 작업시간이 작은순, 들어온 시간 작은순
         *
         * 1. 0,3을 대입  들어온시간이 0인경우 모두 투입
         * 2. 제일 작은 작업시간을 실행
         * 3. 작업이 끝난시간이 3초이므로 들어온 시간이 3초보다 작은 작업에 대해 모두 대입
         * 4. 반복
         *
         * queue가 빌때까지 반복
         * 1. 작업이 완료되면 작업요청부터 종료까지 걸린 시간의 평균을 계산해서 더한다.
         * 2. 작업 들어가기전에 들어온 시간을 체크
         *    2-1  5ms에 들어왔는데 작업 시작인 6ms면 그냥 진행
         *    2-2  5ms에 들어왔는데 작업 시작이 3ms이면 (5-3) 추가로 더해주고 진행
         */
        PriorityQueue<Jobs> priorityQueue = new PriorityQueue<>();

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int totalTime = 0;
        int curTime = 0;
        int count = 0;

        while (count < jobs.length || !priorityQueue.isEmpty()) {

            while (count < jobs.length && curTime == jobs[count][0]) {
                priorityQueue.add(new Jobs(jobs[count][0], jobs[count][1]));
                count++;
            }

            if (!priorityQueue.isEmpty()) {
                Jobs poll = priorityQueue.poll();
                curTime += poll.workT;
                totalTime += curTime - poll.enterT;

                while (count < jobs.length && curTime >= jobs[count][0]) {
                    priorityQueue.add(new Jobs(jobs[count][0], jobs[count][1]));
                    count++;
                }
            } else {
                curTime++;
            }
        }

        return totalTime/count;
    }
}
