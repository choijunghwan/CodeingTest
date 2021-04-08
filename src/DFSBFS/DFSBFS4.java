package DFSBFS;

import java.util.*;

public class DFSBFS4 {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] tickets = {{"ICN","A"},{"ICN","B"},{"B","ICN"}};
//        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
        String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
        ArrayList<String> answer = new ArrayList<>();
        answer.add("ICN");

        boolean[] visited = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            visited[i] = false;
        }

        dfs("ICN", visited, answer, tickets);

        System.out.println("answer = " + answer);

        String[] array = answer.toArray(new String[answer.size()]);

    }

    static ArrayList<String> dfs(String begin, boolean[] visited, ArrayList<String> answer, String[][] tickets) {

        // 종료조건: 모든 곳을 방문했을경우
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == true) {
                count++;
            }
        }

        if (count == visited.length) {
            return answer;
        }

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < visited.length; i++) {
            if (begin.equals(tickets[i][0]) && !visited[i]) {
                map.put(tickets[i][1], i);
            }
        }


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("entry.getKey = " + entry.getKey());
            System.out.println("entry.getValue = " + entry.getValue());
            int check = 0;
            for (int i = 0; i < visited.length; i++) {
                if (entry.getKey().equals(tickets[i][0])) {
                    check++;
                }
            }

            if (check > 0) {
                visited[entry.getValue()] = true;
                answer.add(entry.getKey());
                dfs(entry.getKey(), visited, answer, tickets);
                break;
            }

            if (check == 0 && count == visited.length - 1) {
                answer.add(entry.getKey());
            }
        }

//        visited[map.get(map.firstKey())] = true;
//        answer.add(map.firstKey());
//        dfs(map.firstKey(), visited, answer, tickets);


        return answer;
    }

}
