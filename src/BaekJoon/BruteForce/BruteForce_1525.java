package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BruteForce_1525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(br.readLine().replace(" ", ""));
        }

        if (sb.toString().equals("123456780")) {
            System.out.println(0);
        } else {
            int result = bfs(sb.toString());
            System.out.println(result);
        }
    }

    private static int bfs(String start) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        map.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String str = queue.poll();
            int zeroIdx = str.indexOf("0");
            int row = zeroIdx / 3;  // 행
            int col = zeroIdx % 3;  // 열

            for (int i = 0; i < 4; i++) {
                int nextX = row + dx[i];
                int nextY = col + dy[i];

                if (nextX < 0 || nextX >= 3 || nextY < 0 || nextY >= 3) {
                    continue;
                }

                int swapIdx = nextX * 3 + nextY;
                StringBuilder sb = new StringBuilder(str);
                char ch = sb.charAt(swapIdx);
                sb.setCharAt(swapIdx, '0');
                sb.setCharAt(zeroIdx, ch);

                if (sb.toString().equals("123456780")) {
                    return map.get(str) + 1;
                }

                if (!map.containsKey(sb.toString())) {
                    queue.add(sb.toString());
                    map.put(sb.toString(), map.get(str) + 1);
                }
            }
        }

        return -1;
    }
}
