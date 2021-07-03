import Heap.Heap2;
import QUEUE.Queue4;

public class Main {
    public static void main(String[] args) {
        /**
         * 프로그래머스 Queue 4번 문제
         */
        Queue4 queue4 = new Queue4();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int solution = queue4.solution(priorities, location);
        System.out.println("solution = " + solution);


        Heap2 heap2 = new Heap2();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int result = heap2.solution(jobs);
        System.out.println("result = " + result);


    }
}
