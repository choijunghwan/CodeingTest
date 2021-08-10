package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 동생 <= 수빈 라면 -1씩 이동하면 찾는다.
 * 2. 수빈 < 동생
 *     2-1 Queue 자료구조를 이용한다.
 *     2-2 수빈*2 가 동생보다 작으면 순간이동을 한다.
 *     2-3 수빈*2 > 동생 이면   수빈 -1, 수빈 +1, 수빈 * 2 모든 경우를 Queue 에 담는다.
 */
public class BruteForce_1697 {
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
    }

    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        check[num] = 0;

        while (true) {
            int poll = queue.poll();

            if (poll == K) {
                System.out.println(check[poll]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = poll - 1;
                } else if (i == 1) {
                    next = poll + 1;
                } else {
                    next = poll * 2;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[poll] + 1;
                }
            }

        }
    }
}

