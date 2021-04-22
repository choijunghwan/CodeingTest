package Greedy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Greedy4 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int answer = solution(people, limit);
        System.out.println("answer = " + answer);

    }

    /**
     * 사람들을 앞에서부터 차례로 최대한 태워서 탈출한다.
     * limit 100,        80 90 10 20 30 50 60 60 50 60 40 50
     * 내림차순정렬 -> 90 80 60 50 50 40 40 40 40 40 30 20 10
     * 오름차순정렬 -> 10 20 30 40 40 40 40 40 50 50 60 80 90
     *
     * 1. 제일 큰수를 뽑는다
     * 2. 제일 작은수랑 합쳐서   큰수 + 작은수 <= limit 하면 둘다 삭제  큰수 + 작은수 > limit 하면 큰수만 삭제
     * 3. 숫자가 한개만 남으면 한개만 삭제시키고 종료
     */
    public static int stack_solution(int[] people, int limit){
        Queue<Integer> des_queue = new LinkedList<>();
        Queue<Integer> asc_queue = new LinkedList<>();

        // 내림차순
//        Integer[] integerArr = Arrays.stream(people).boxed().toArray(Integer[]::new);
//        Arrays.sort(integerArr, Comparator.reverseOrder());
//        int len = integerArr.length;
//        for (int i = 0; i < len; i++) {
//            des_queue.offer(integerArr[i]);
//            asc_queue.offer(integerArr[len - 1 - i]);
//        }

        // 오름차순
        Arrays.sort(people);
        int len = people.length;
        for (int i = 0; i < len; i++) {
            des_queue.offer(people[len - 1 - i]);
            asc_queue.offer(people[i]);
        }

        int count = 0;
        while (!des_queue.isEmpty()) {
            if (des_queue.size() == 1) {
                des_queue.poll();
                count++;
                continue;
            }

            Integer poll = des_queue.poll();
            Integer peek = asc_queue.peek();

            if (poll <= limit / 2) {
                count += Math.ceil((double) (des_queue.size()+1) / 2);
                break;
            }

            if (poll + peek <= limit) {
                des_queue.remove(peek);
                asc_queue.poll();
//                asc_queue.remove(poll);
            } else {
//                asc_queue.remove(poll);
            }

            count++;

        }

        return count;
    }

    /**
     * Array보다 stack이 더 빠를것이다라는 편견을 버리자.
     * array를 통해 탐색하니 훨씬 빠르다.
     */
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int first = people.length -1;
        int second = 0;
        int count = 0;

        while (first >= second) {
            if (people[first] <= limit / 2) {
                count += Math.ceil((double) (first - second + 1) / 2);
                break;
            }
            if (people[first] + people[second] <= limit) {
                first--;
                second++;
                count++;
            } else {
                first--;
                count++;
            }
        }

        return count;
    }

}
