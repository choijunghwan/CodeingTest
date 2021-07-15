package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DC_11729 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            count += Math.pow(2, i);
        }
        System.out.println(count);
        sb = new StringBuilder();
        move(N, 1, 3);
        System.out.println(sb.toString());
    }

    // N개의 원판을 A에서 C로 이동시킬려면
    // (N-1)개의 원판을 A에서 B로 이동 -> N 원판을 A에서 C로 이동 -> (N-1)개의 원판을 B에서 C로 이동
    private static void move(int depth, int start, int end) {
        // 어차피 경우의 수가 1,2,3 세가지 이므로
        // move 함수 매개변수를 출발지, 임시방문장소, 목적기 세가지를 전달해주고
        // 호출할 때 순서를 바꿔준다.
        // ex) move(N , 1, 2, 3) 이라면 1에서 3으로 보내고 2는 임시 방문장소이다
        //     이걸 넘겨줄때는 move(N-1, 1, 3, 2) 1에서 2로 보내고 3은 임시 방문장소가 되게
        //     순서만 바꿔 보내주면 굳이 find 함수를 사용할 필요가 없다.
        int dropBy = find(start, end);

        if (depth == 1) {
            sb.append(start + " " + end + "\n");
//            System.out.println(start + " " + end);
            return ;
        }

        move(depth - 1, start, dropBy);
        sb.append(start + " " + end + "\n");
//        System.out.println(start + " " + end);
        move(depth -1, dropBy, end);
    }

    private static int find(int start, int end) {
        boolean[] check = new boolean[3];
        check[start -1] = true;
        check[end - 1] = true;

        for (int i = 0; i < 3; i++) {
            if (!check[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
