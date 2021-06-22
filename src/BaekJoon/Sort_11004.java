package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sort_11004 {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quicksort(arr, 0, N - 1);
        System.out.println(arr[K-1]);

    }

    public static void quicksort(int[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }

        int pi = partition(arr, left, right);

        if (pi + 1 == K) return ;
        else if (pi + 1 < K) {
            quicksort(arr, pi + 1, right);
        } else {
            quicksort(arr, left, pi-1);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = arr[mid];
        swap(arr, left, mid);  // 중앙 값을 첫 번째 요소로 이동

        int i = left, j = right;

        while (i < j) {
            while(pivot < arr[j]) j--;  // 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다
            while(i < j && pivot >= arr[i]) {
                i++;  // 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다
            }
            swap(arr, i, j);
        }

        // 반복문을 벗어난 경우는 i와 j가 만난경우
        swap(arr, left, i);

        return i;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
