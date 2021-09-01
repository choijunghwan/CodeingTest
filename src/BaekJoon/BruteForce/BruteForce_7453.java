package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 완전탐색으로 풀경우 시간복잡도가 N^4로 N이 4000이기때문에 시간초과가 발생한다.
 * 따라서 시간복잡도를 줄이는 로직이 필요한데
 * 4개의 배열 A,B,C,D를 AB, CD로 줄여서 투 포인터를 통해 합을 구하면
 * 시간복잡도 -> N^2 = 1600만 + 투포인터 N 1600만 이 걸리기 때문에 시간을 절약할 수 있다.
 */
public class BruteForce_7453 {

    static int N;
    static int[] A,B,C,D;
    static int[] AB, CD;
    static int ABid, CDid;
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];
        AB = new int[N*N];
        CD = new int[N*N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        ABid = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[ABid] = A[i] + B[j];
                CD[ABid] = C[i] + D[j];
                ABid++;
            }
        }
        CDid = ABid -1;

        Arrays.sort(AB);
        Arrays.sort(CD);

        for (int i = 0; i < ABid && CDid >= 0; ) {
            int ABsum = AB[i];
            int CDsum = CD[CDid];
            int ABcnt = 0;
            int CDcnt = 0;
            int totSum = ABsum + CDsum;

            if (totSum == 0) {
                // AB에서 중복인 답의 개수를 체크
                while (i < ABid && ABsum == AB[i]) {
                    i++;
                    ABcnt++;
                }

                // CD에서 중복인 답의 개수를 체크
                while (CDid >= 0 && CDsum == CD[CDid]) {
                    CDid--;
                    CDcnt++;
                }

                ans += (long) ABcnt * (long) CDcnt;
            } else if (totSum > 0) {
                CDid--;
            } else {
                i++;
            }
        }

        System.out.println(ans);

    }


}
