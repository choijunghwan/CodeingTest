package DFSBFS;

import java.util.*;

/**
 * 나의 코드와 구글링 코드의 차이점은
 * 나는 dfs를 사용할때 일일이 정렬을 하여 삽입하고 route를 찾았다면
 * 구글링 코드는 모든 경우를 다 찾아서 넣고, 모든 경우들을 모아놓고 정렬을 하여 결과값을 찾았다.
 */
public class DFSBFS4 {
    private static final int SRC = 0;
    private static final int DST = 1;

    private static ArrayList<String> answer = new ArrayList<>();
    private static String route = "";
    private static boolean[] visited;


    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] tickets = {{"ICN","A"},{"ICN","B"},{"B","ICN"}};
//        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
//        String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}, {"A", "C"}};
        String[][] tickets = {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}};

        /*
        ArrayList<String> answer = new ArrayList<>();
        answer.add("ICN");
        boolean[] visited = new boolean[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            visited[i] = false;
        }
        self_dfs("ICN", visited, answer, tickets);
        System.out.println("answer = " + answer);
        String[] array = answer.toArray(new String[answer.size()]);
        */

        for (int i = 0; i < tickets.length; i++){
            visited = new boolean[tickets.length];
            String src = tickets[i][SRC];
            String dst = tickets[i][DST];

            if (src.equals("ICN")){
                route = src + ",";
                visited[i] = true;
                dfs(tickets, dst, 1);
            }
        }
        Collections.sort(answer);

    }

    static void dfs(String[][] tickets, String dst, int visitCount) {
        route += dst + ",";

        if (visitCount == tickets.length){
            answer.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String nextSrc = tickets[i][SRC];
            String nextDst = tickets[i][DST];

            if (dst.equals(nextSrc) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, nextDst, visitCount+1);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }

        }
    }

    static ArrayList<String> self_dfs(String begin, boolean[] visited, ArrayList<String> answer, String[][] tickets) {

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
                self_dfs(entry.getKey(), visited, answer, tickets);
                break;
            }

            if (check == 0 && count == visited.length - 1) {
                answer.add(entry.getKey());
            }
        }

        return answer;
    }

}
