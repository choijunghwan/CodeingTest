package Programmers.ExhaustiveSearch;

import java.util.ArrayList;

public class ExhaustiveSearch2 {
    public static void main(String[] args) {
        String numbers = "123";

        // 문자열을 split함수를 이용해 자른다.
        String[] splitNumbers = numbers.split("");
        int length = splitNumbers.length;

        ArrayList<Integer> lists = new ArrayList<>();

        for (int i = 1; i <= length; i++) {
            permutation(lists, splitNumbers, 0, length, i);
        }

        System.out.println("lists = " + lists);
        ArrayList<Integer> distinctList = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (!distinctList.contains(lists.get(i))) {
                distinctList.add(lists.get(i));
            }
        }
        System.out.println("distinctList = " + distinctList);
        int answer = 0;

        for (Integer list : distinctList) {
            if (IsPrimeNumber(list)) {
                answer++;
            }
        }

        System.out.println("answer = " + answer);


    }

    static boolean IsPrimeNumber(int number){

        if (number == 1) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        // 2를 제외한 소수는 항상 홀수
        if (number % 2 == 0) {
            return false;
        }

        // 소수는 홀수 이므로 짝수로 나누는 과정을 생략한다.
        for (int n = 3; n < number; n += 2) {
            if (number % n == 0) {
                return false;
            }
        }

        return true;
    }

    // 순서 없이 n개중에서 r개를 뽑는 경우
    // 사용 예시: permutation(arr, 0, n, 4);
    static void permutation(ArrayList<Integer> lists, String[] arr, int depth, int n, int r) {

        if (depth == r) {
            print(arr, r);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(arr[i]);
            }
            int num = Integer.parseInt(sb.toString());
            lists.add(num);
            return ;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(lists, arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    static void print(String[] arr, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
