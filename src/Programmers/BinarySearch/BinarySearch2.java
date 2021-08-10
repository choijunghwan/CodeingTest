package Programmers.BinarySearch;

import java.util.Arrays;

public class BinarySearch2 {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        int answer = solution(distance, rocks, n);
        System.out.println("answer = " + answer);
    }

    /**
     * 이 문제를 이분탐색으로 풀기위해서는 생각의 전환이 필요하다.
     * 돌을 n개만큼 없앴을대 돌사이의 거리중 최솟값 중에 최댓값을 구하는게 문제라면
     * 우리는 다르게 생각하여 n개의 돌을 없애서 돌 사이 거리의 최솟값이 x로 만들 수 있는가??
     * 로 바꿔 생각해봐야한다.
     */
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        long answer = 0;
        long left = 1;
        long right = distance;
        long mid = 0;   // 최솟값


        while(left <= right){
            long prev = 0;
            int cnt = 0;

            mid = (left + right) / 2;

            // 돌간의 거리를 비교해보면서 최솟값을 만들수 있으면
            // pass하고, 만들 수 없으면 해당 돌을 제거해 나간다.
            for (int i = 0; i < rocks.length; i++){
                if (rocks[i] - prev < mid){
                    // 더 작은 최솟값을 만들 수 있다는 의미
                    // 해당 돌은 제거한다.
                    cnt++;
                } else {
                    // 우리가 만들려는 최솟값보다 크거나 값으므로
                    // 다시 prev를 현재 돌로 초기화해서 탐색한다.
                    prev = rocks[i];
                }
            }

            // 마지막 돌과 도착점 사이의 거리도 확인한다.
            if (distance - prev < mid) cnt++;

            if (cnt <=n){
                // 지운 돌의 갯수가 n보다 작거나 같은 만큼 돌을 없애서
                // 최솟값 x를 만들 수 있다
                answer = mid > answer ? mid : answer;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) answer;
    }
}
