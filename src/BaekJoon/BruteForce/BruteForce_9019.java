package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 완전 탐색으로 모든 경우를 탐색
 * bfs로 탐색
 * 다만, 최종 값을 찾았을때 그동안에 명령어를 출력하는게 문제.
 * -> bfs를 탐색할때 그동안의 명령어를 문자열로 저장해 넘겨주자
 */
public class BruteForce_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            String result = bfs(A, B);
            System.out.println(result);
        }
    }

    private static String bfs(int A, int B) {
        boolean[] visited = new boolean[10000];
        Queue<Dslr> queue = new LinkedList<>();
        queue.add(new Dslr(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Dslr dslr = queue.poll();

            if (dslr.num == B) {
                return dslr.cmd;
            }

            int cmdFromD = cmdD(dslr.num);
            if (!visited[cmdFromD]) {
                queue.add(new Dslr(cmdFromD, dslr.cmd + "D"));
                visited[cmdFromD] = true;
            }

            int cmdFromS = cmdS(dslr.num);
            if (!visited[cmdFromS]) {
                queue.add(new Dslr(cmdFromS, dslr.cmd + "S"));
                visited[cmdFromS] = true;
            }

            int cmdFromL = cmdL(dslr.num);
            if (!visited[cmdFromL]) {
                queue.add(new Dslr(cmdFromL, dslr.cmd + "L"));
                visited[cmdFromL] = true;
            }

            int cmdFromR = cmdR(dslr.num);
            if (!visited[cmdFromR]) {
                queue.add(new Dslr(cmdFromR, dslr.cmd + "R"));
                visited[cmdFromR] = true;
            }
        }

        return "변환 불가능";
    }

    private static int cmdR(int num) {
        int temp = num % 10; // 일의 자리 숫자를 구한다.

        return (num / 10) + (temp * 1000);
    }

    private static int cmdL(int num) {
        int temp = num / 1000;  // 천의 자리 숫자를 구한다.

        return (num * 10) % 10000 + temp;
    }

    private static int cmdS(int num) {
        if (num == 0) {
            return 9999;
        }
        return num - 1;
    }

    private static int cmdD(int num) {
        if (num * 2 < 10000) {
            return num * 2;
        }

        return (num * 2) % 10000;
    }

}

class Dslr {
    int num;
    String cmd;

    public Dslr(int num, String cmd) {
        this.num = num;
        this.cmd = cmd;
    }
}