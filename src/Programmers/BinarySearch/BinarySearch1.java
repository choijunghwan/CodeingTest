package Programmers.BinarySearch;

public class BinarySearch1 {
    public static void main(String[] args) {
        int n = 9;
        int[] times = {5, 7, 10};

        long answer = solution(n, times);
        System.out.println("answer = " + answer);
    }

    public static long solution(int n, int[] times) {
        long maxTime = 0;
        for (int t : times){
            maxTime = Math.max(maxTime, t);
        }

        long start = 1;
        long end = maxTime * (long) n;
        long mid = 0;
        long answer = 0;

        while (start <= end){
            long passNum = 0;
            mid = (end + start) / 2;
            for (int t : times){
                passNum += mid / t;
            }


            if (passNum < n){
                start = mid +1;
            } else{              // passNum == n 이여도 그때의 시간이 최소가 아닐수 있으므로
                end = mid -1;    // 최대한 시간을 줄여본다.
                answer = mid;    // 예를들어 n=9 일려면 21분도 가능하지만, 22분,23분도 가능하다.
            }
        }

        return answer;
    }
}
