package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];

            // 음수인경우
            if (temp < 0) {
                // 음수가 연속해서 있는 경우
                if (i + 1 < arr.length && arr[i + 1] <= 0) {
                    sum += temp * arr[i + 1];
                    i++;
                }
                // (음수 , 양수) 인 경우
                else if (i + 1 < arr.length && arr[i + 1] >= 1) {
                    sum += temp;
                }
                // 마지막 수인 경우
                else if (i + 1 == arr.length) {
                    sum += temp;
                }
            }
            // 0,1 인경우에는 그냥 더해준다.
            else if (temp == 0 || temp == 1) {
                sum += temp;
            }
            // 2이상인 경우
            else if (temp >= 2) {
                // 남은 수가 홀수개 인 경우
                if ((arr.length - i) % 2 == 1) {
                    sum += temp;
                }
                // 남은 수가 짝수개 인 경우
                else {
                    sum += temp * arr[i + 1];
                    i++;
                }
            }
        }

        System.out.println(sum);
    }
}
