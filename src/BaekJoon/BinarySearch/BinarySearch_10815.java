package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 하나의 수가 배열에 속해있는지 없는지를 판단하는 문제
 * 이분탐색을 이용
 *
 * 1. 이분탐색을 하기 위해서 먼저 숫자카드를 오름차순으로 정렬해야 한다.
 * 2. 주어진 정수를 이분탐색을 통해 값이 있는지 없는지 찾아본다.
 */
public class BinarySearch_10815 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색을 하기 위해 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st1.nextToken());
            sb.append(binarysearch(num) + " ");
        }

        System.out.println(sb.toString());
    }


    private static int binarysearch(int num) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == num) {
                return 1;
            } else if (arr[mid] < num) {
                low = mid + 1;
            } else if (arr[mid] > num) {
                high = mid - 1;
            }
        }

        return 0;
    }
}
