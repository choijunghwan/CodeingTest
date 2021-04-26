package Greedy;


import java.util.Arrays;

public class Greedy6 {
    public static void main(String[] args) {
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};

        int answer = solution(routes);
        System.out.println("answer = " + answer);

    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes);

        for (int[] route : routes){
            System.out.println(route[0] + route[1]);
        }

        return 0;
    }
}
