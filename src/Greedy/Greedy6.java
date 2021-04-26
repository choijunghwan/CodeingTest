package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy6 {
    public static void main(String[] args) {
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};

        int answer = solution(routes);
        System.out.println("answer = " + answer);

    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes,
                new Comparator<int[]>(){

                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] < o2[0] ? -1 : 1;
                    }
                });

        for (int[] route : routes){
            System.out.println(route[0] + " " + route[1]);
        }

        int start = routes[0][0];
        int end = routes[0][1];
        int count = 1;

        for (int[] route : routes){

            if (route[0] <= end) {
                if (end > route[1]) {
                    end = route[1];
                }
                start = route[0];
            } else {
                start = route[0];
                end = route[1];
                count++;
            }
        }

        return count;
    }
}
