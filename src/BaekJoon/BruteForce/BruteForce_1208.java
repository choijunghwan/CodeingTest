package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BruteForce_1208 {

    static int N;
    static int S;
    static int[] arr;
    static long cnt = 0;
    static ArrayList<Integer> leftList = new ArrayList<>();
    static ArrayList<Integer> rightList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        makeSum(0, 0, N / 2, leftList);
        makeSum(0, N / 2, N, rightList);

        Collections.sort(leftList);
        Collections.sort(rightList);

        calcC();

        System.out.println(S == 0 ? cnt - 1 : cnt);


    }

    private static void calcC() {
        int start = 0;
        int end = rightList.size() - 1;

        while (true) {
            if (start == leftList.size() || end < 0) {
                break;
            }

            int lv = leftList.get(start);
            int rv = rightList.get(end);

            if (lv + rv == S) {
                long lc = 0;
                while (start < leftList.size() && leftList.get(start) == lv) {
                    lc++;
                    start++;
                }

                long rc = 0;
                while (0 <= end && rightList.get(end) == rv) {
                    rc++;
                    end--;
                }
                cnt += lc * rc;
            }

            if (lv + rv > S) {
                end--;
            }
            if (lv + rv < S) {
                start++;
            }
        }
    }

    private static void makeSum(int sum, int start, int end, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        makeSum(sum, start + 1, end, list);
        makeSum(sum + arr[start], start + 1, end, list);
    }
}
