package Programmers.DynamicProgramming;

import java.util.Scanner;

/**
 * 동적 계획법이란?
 * 쉽게 정의하면, 이전에 구한 답을 다시 가져오는 방법이다.
 * 재귀방식은 코드가 간단하고, 직관적이지만 함수를 연속적으로 불러야 하기 때문에
 * 컴파일러는 해당 코드를 읽을 때 수많은 오버헤드가 발생 될 것이다.
 * 메소드를 부르기 위해 Stack에 명령이 쌓이고, 쉽게 Stack Overflow가 발생한다.
 * 이걸 해결하기 위해 고안된 것이 동적계획법이다.
 */
public class DP_theory {
    static int[] fibo_memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        fibo_memo = new int[45];
    }

    // 재귀함수를 이용한 피보나치 수열
    // 재귀함수를 사용하면 시간복잡도가 O(2^n)이다.
    static int recursive_fibo(int a) {
        if (a == 1 || a == 2) {
            return a;
        }
        return recursive_fibo(a - 1) + recursive_fibo(a - 2);
    }

    // 동적계획법을 이용한 피보나치 수열
    // 과거에 구한 답을 저장하여, 메소드를 불러오는 횟수를 줄이는 방식이다.
    static void fibo(int a) {
        fibo_memo[0] = 0;
        fibo_memo[1] = 1;

        for (int i = 2; (i<=a) && (i < 45); i++) {
            fibo_memo[i] = fibo_memo[i - 1] + fibo_memo[i - 2];
        }

        System.out.println("fibo_dp(a) = " + fibo_dp(a));
    }

    static int fibo_dp(int a) {
        if (a < 45) return fibo_memo[a];
        else {
            return fibo_dp(a - 1) + fibo_dp(a - 2);
        }
    }

}
