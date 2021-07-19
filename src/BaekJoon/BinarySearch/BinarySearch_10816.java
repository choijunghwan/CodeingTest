package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] cnt = new int[20000001];

        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(cnt[Integer.parseInt(st.nextToken()) + 10000000] + " ");
        }

        System.out.println(sb.toString());
        /*int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st1.nextToken());
            int low = 0;
            int high = arr.length - 1;
            int count = 0;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (arr[mid] <= num) {
                    low = mid + 1;
                } else if (arr[mid] > num) {
                    high = mid - 1;
                }
            }

            while (high >= 0 && arr[high--] == num) {
                count++;
            }

            sb.append(count + " ");
        }

        System.out.println(sb.toString());*/
    }
}
