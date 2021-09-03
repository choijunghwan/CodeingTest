package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BruteForce_2143 {
    static int T;
    static int N, M;
    static int[] A, B;
    static long ans = 0;
    static ArrayList<Integer> AList = new ArrayList<>();
    static ArrayList<Integer> BList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            getSum(A[i], i+1, A, AList);
        }

        for (int i = 0; i < M; i++) {
            getSum(B[i], i+1, B, BList);
        }

        Collections.sort(AList);
        Collections.sort(BList);

        getAns();

        System.out.println(ans);
    }

    private static void getAns() {
        int leftIdx = 0;
        int rightIdx = BList.size() - 1;

        while (leftIdx < AList.size() && rightIdx >= 0) {
            int lv = AList.get(leftIdx);
            int rv = BList.get(rightIdx);

            if (lv + rv == T) {
                int lc = 0;
                while (leftIdx < AList.size() && AList.get(leftIdx) == lv) {
                    lc++;
                    leftIdx++;
                }

                int rc = 0;
                while (rightIdx >= 0 && BList.get(rightIdx) == rv) {
                    rc++;
                    rightIdx--;
                }
                ans += (long) lc * rc;
            } else if (lv + rv < T) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
    }

    private static void getSum(int sum, int idx, int[] arr, ArrayList<Integer> list) {

        list.add(sum);

        if (idx == arr.length) {
            return;
        }

        getSum(sum + arr[idx], idx + 1, arr, list);
    }
}
