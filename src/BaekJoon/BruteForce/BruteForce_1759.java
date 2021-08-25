package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BruteForce_1759 {
    /**
     * n개중 r개로 만들수 있는 순열을 모두 찾은뒤
     * 그중 모음 최소 1개, 자음 최소 2개 조건이 성립하느것만 출력
     */
    static char[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    static int L;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        DFS(0, 0, 0, 0);

        System.out.println(sb.toString());
    }

    private static void DFS(int start, int depth, int ja, int mo) {

        for (int i = start; i < C; i++) {
            visited[i] = true;
            DFS(i + 1, depth + 1, ja + (check(arr[i]) ? 0 : 1), mo + (check(arr[i]) ? 1 : 0));
            visited[i] = false;
        }

        if (depth == L && ja >= 2 && mo >= 1) {
            print();
        }
    }

    private static void print() {
        for (int i = 0; i < C; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
            }
        }
        sb.append("\n");
    }

    private static boolean check(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }


}
