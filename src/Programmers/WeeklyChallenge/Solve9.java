package Programmers.WeeklyChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solve9 {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            boolean[] isVisited = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            isVisited[1] = true;
            int oneWireCnt = 0;

            while(!q.isEmpty()) {
                int temp = q.poll();
                oneWireCnt++;
                for (int next : list.get(temp)) {
                    if ((temp == v1 && next == v2) || (temp == v2 && next == v1)) {
                        continue;
                    }

                    if (!isVisited[next]) {
                        q.add(next);
                        isVisited[next] = true;
                    }
                }
            }

            int anotherWireCnt = n - oneWireCnt;

            answer = Math.min(answer, Math.abs(anotherWireCnt - oneWireCnt));

        }

        return answer;
    }
}
