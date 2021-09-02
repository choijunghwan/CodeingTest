package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BruteForce_2632 {
    static int M, N, S;
    static int[] A, B;
    static int ans;
    static boolean check[];
    static ArrayList<Integer> AList = new ArrayList<>();
    static ArrayList<Integer> BList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        A = new int[M];
        B = new int[N];

        for (int i = 0; i < M; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            // check배열 초기화
            check = new boolean[M];
            // 첫 번째 조각 담기
            check[i] = true;
            getSum(A[i], i, i + 1, check, A, AList);
        }

        for (int i = 0; i < N; i++) {
            check = new boolean[N];
            check[i] = true;
            getSum(B[i], i, i + 1, check, B, BList);
        }

        AList.add(0);
        BList.add(0);

        Collections.sort(AList);
        Collections.sort(BList);

        getAns();

        System.out.println(ans);


    }

    private static void getAns() {
        int leftIdx = 0;
        int rightIdx = BList.size() - 1;

        while (leftIdx < AList.size() && 0 <= rightIdx) {
            int lv = AList.get(leftIdx);
            int rv = BList.get(rightIdx);

            if (lv + rv == S) {
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

                ans += lc * rc;
            } else if (lv + rv < S) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
    }

    // 부분합 구하기
    private static void getSum(int sum, int startIdx, int idx, boolean[] check, int[] arr, ArrayList<Integer> list) {
        // 들어온 인덱스가 끝이면 원형이기 때문에 다시 0으로 처리
        if (idx == arr.length) {
            idx = 0;
        }

        list.add(sum);

        // 아직 안 담은 피자조각에대해서만 판매함 && 마지막 인덱스 값을 계속 저장하지 않음
        // 순열의 합이 이미 타켓을 넘어서면 계산하지 않음
        if (!check[idx] && idx != startIdx - 1 && sum <= S) {
            check[idx] = true;
            getSum(sum + arr[idx], startIdx, idx + 1, check, arr, list);
        } else {
            return;
        }
    }
}
