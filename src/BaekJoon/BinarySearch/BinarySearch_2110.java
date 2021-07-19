package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1  2  4  8  9
 *
 * 1. C개의 공유기를 어떤 기준으로 설치할것인가? (완전탐색? , ??)
 *    - 거리를 먼저 정해서 탐색해보자. (Binary Search를 거리에 적용하는것이다.)
 *    - 먼저 (1 + 9) / 2 = 5 를 기준으로 탐색해보자.
 *    - 1 일때 설치를 하고, 거리가 5보다 먼곳에만 공유기를 설치해본다. -> (1,8)에만 설치 가능하다.
 *    - 개수가 부족하므로 거리를 줄여서 반복탐색한다.
 */
public class BinarySearch_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        // List보다 배열을 쓴 이유는
        // 1. 배열의 크기를 알 수 있다.
        // 2. 배열의 값에 대한 조회가 자주 일어나는데, List는 순차적으로 값을 접근해야 해서 조회 성능이 안좋다.
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 집들이 수직선 위에 있으니 집들의 거리를 구하기 편하게 오름차순으로 정렬한다.
        // 이진 탐색(Binaray Search)를 하기 위해서 반드시 배열이 정렬되어 있어야 한다.
        Arrays.sort(arr);

        int low = 1;
        int high = arr[N - 1] - arr[0];

        while (low <= high) {
            int mid = (high + low) / 2;
            int left = arr[0];
            int count = 1;
            for (int i = 0; i < N; i++) {
                if (arr[i] - left >= mid) {
                    left = arr[i];
                    count++;
                }
            }

            if (count < C) {
                high = mid - 1;
            } else if (count >= C) {  // C개 공유기 설치 가능한경우중에 최대값을 구하기 위해 등호 추가
                low = mid + 1;
            }
        }

        System.out.println(high);
    }
}
