package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘에 착안해 문제를 푼다.
 * 1. x좌표를 기준으로 정렬한다
 * 2. 회의실 이용의 최대 값을 구해야 하므로, 회의시간이 제일 작은거를 찾는것이 중요하다.
 *      2.1 x좌료를 기준으로 반복해서 탐색하면서, 가장 작은 회의시간을 찾는다.
 * 3. 회의 시작시간과 종료시간이 같은 경우
 */
public class Greedy_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        // 종료시간을 기준으로 정렬
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Long.compare(o1[0], o2[0]);
            }
            return Long.compare(o1[1], o2[1]);
        }));

        int count = 0;
        long prev_end_time = 0;

        for (int i = 0; i < N; i++) {

            if (prev_end_time <= arr[i][0]) {
                prev_end_time = arr[i][1];
                count++;
            }
        }

        System.out.println(count);


    }
}
