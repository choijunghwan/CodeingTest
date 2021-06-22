package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        if(n==1) { // n이 1일 경우는 0번 인덱스만 출력해주면 된다.
            System.out.println(arr[0]);
            return;
        }
        Arrays.sort(arr);

        int cnt = 1;
        int max = 0;
        long ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (i == n - 2) {
                if (arr[i] == arr[i + 1]) {
                    cnt++;
                }
                if (cnt > max) {
                    max = cnt;
                    ans = arr[i];
                }

            }
            else if (arr[i] == arr[i + 1]) {
                cnt++;
            }
            else {
                if (cnt > max) {
                    max = cnt;
                    ans = arr[i];
                }
                cnt = 1;
            }
        }

        System.out.println(ans);
    }
}
