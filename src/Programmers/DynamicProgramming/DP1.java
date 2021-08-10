package Programmers.DynamicProgramming;

import java.util.TreeSet;

public class DP1 {

    static int _N;
    static TreeSet<Integer>[] dynamic;

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        int num = 0;

        int ans = solution(N, number);
        System.out.println("answer = " + ans);


        /**
         * N 1번 이용 -> 무조건 1자리수
         * N 2번 이용 -> N 과 N을 사칙연산 or NN
         * N 3번 이용 -> NN 과 N을 사칙연산 or N과 NN을 사칙연산 or NNN
         * N 4번 이용 -> NNN과 N을 사칙연산 or NN과 NN을 사칙연산 or N과 NNN을 사칙연산 or NNNN
         * d[4] = d[4-i] + d[i] 과 NNNN
         */


        /**
         *
         */
    }

    public static int solution(int N, int number) {
        _N = N;
        dynamic = new TreeSet[10];

        if (N == number) {
            return 1;
        }

        for (int i = 0; i <= 8; i++) {
            solve(i);

            // 연산결과 number와 값이 일치하면 return
            if (dynamic[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }

    public static TreeSet<Integer> solve(int n) {
        // 이미 존재하는 값인지 체크
        if ((dynamic[n] != null) && !dynamic[n].isEmpty()) {
            return dynamic[n];
        }

        // N을 이어서 붙인 NN...N 값 만들기
        int NN = 0;
        for (int i = 0; i < n; i++) {
            NN = (10 * NN) + _N;
        }

        TreeSet<Integer> temp = new TreeSet<>();
        temp.add(NN);

        // d[n] = d[n-i] + d[i]
        for (int i = 1; i < n; i++) {
            int j = n-i;
            TreeSet<Integer> from = solve(i);    // d[i] 집합
            TreeSet<Integer> to = solve(j);      // d[n-i] 집합

            for (int n1 : from) {
                for (int n2 : to) {
                    temp.add(n1 + n2);
                    temp.add(n1 - n2);
                    temp.add(n1 * n2);
                    if (n2 !=0) temp.add(n1 / n2);
                }
            }
        }

        return dynamic[n] = temp;
    }

}
