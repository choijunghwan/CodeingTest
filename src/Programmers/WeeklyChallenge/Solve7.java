package Programmers.WeeklyChallenge;

import java.util.*;

public class Solve7 {

    public int[] solution(int[] enter, int[] leave) {
        int N = enter.length;
        Set<Integer> room = new HashSet<>();
        Map<Integer, Integer> meetCnt = new HashMap<>();
        Queue<Integer> inList = new LinkedList<>();
        Queue<Integer> outList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            inList.add(enter[i]);
            outList.add(leave[i]);
            meetCnt.put(i+1, 0);
        }

        while(!inList.isEmpty()) {
            int in = inList.poll();

            // 이미 입실한 친구들은 새롭게 온 친구 1명을 만났다.
            if (room.size() >= 1) {
                room.forEach(humanNum -> {
                    meetCnt.put(humanNum, meetCnt.get(humanNum) + 1);
                });
            }
            meetCnt.put(in, room.size());  // 새로 입실한 친구는 방에 있는 사람 수 만큼 만났다.
            room.add(in);

            while(!outList.isEmpty() && room.contains(outList.peek())) {
                int out = outList.poll();
                room.remove(out);
            }
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = meetCnt.get(i+1);
        }
        return answer;
    }
}
