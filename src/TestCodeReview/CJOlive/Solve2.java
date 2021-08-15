package TestCodeReview.CJOlive;

import java.util.*;

public class Solve2 {

    public static void main(String[] args) {
        String[] subway = {"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"};
//        String[] subway = {"1 2 3 4 5 6 7 8 9 10", "2 8"};
        int start = 1;
        int end = 10;

        int result = solution(subway, start, end);

        System.out.println("result = " + result);
    }

    static int[][] map;
    static Map<Integer, List<Integer>> station;
    static int changeSubwayMin = Integer.MAX_VALUE;
    public static int solution(String[] subway, int start, int end) {
        map = new int[subway.length][];   // 노선도
        boolean[][] visited = new boolean[subway.length][];
        station = new HashMap<>();  // 역별 환승 정보

        for (int i = 0; i < subway.length; i++) {
            String[] temp = subway[i].split(" ");
            map[i] = new int[temp.length];
            visited[i] = new boolean[temp.length];

            for (int j = 0; j < temp.length; j++){
                map[i][j] = Integer.parseInt(temp[j]);
                if (station.containsKey(map[i][j])) {
                    station.get(map[i][j]).add(i+1);
                } else {
                    station.put(map[i][j], new ArrayList<>(Arrays.asList(i+1)));
                }
            }
        }

        List<Integer> stationlist = station.get(start);
        for (int station : stationlist) {
            int index = 0;
            for (int i = 0; i < map[station-1].length; i++) {
                if (map[station - 1][i] == start) {
                    index = i;
                    break;
                }
            }
            Move move = new Move(start, station, index, +1, 0);
            dfs(move, visited, end);
        }

        return changeSubwayMin;
    }

    private static void dfs(Move move, boolean[][] visited, int end) {
        visited[move.subway - 1][move.index] = true;

        if (move.stationNum == end) {
            changeSubwayMin = Math.min(changeSubwayMin, move.count);
            return;
        }

        int nextIndex = move.index + move.direct;
        if (nextIndex >= 0 && nextIndex < map[move.subway - 1].length) {
            if (!visited[move.subway-1][nextIndex]) {
                Move temp = new Move(map[move.subway - 1][nextIndex], move.subway, nextIndex, move.direct, move.count);
                dfs(temp, visited, end);
                visited[move.subway - 1][nextIndex] = false;
            }
        }

        // 환승 가능한지 체크
        List<Integer> changeList = station.get(move.stationNum);
        for (int cl : changeList) {
            if (cl != move.subway) {
                for (int i = 0; i < map[cl -1].length; i++) {
                    if (move.stationNum == map[cl - 1][i] && !visited[cl -1][i]) {
                        Move temp1 = new Move(move.stationNum, cl, i, 1, move.count + 1);
                        dfs(temp1, visited, end);
                        visited[cl -1][i] = false;
                        Move temp2 = new Move(move.stationNum, cl, i, -1, move.count + 1);
                        dfs(temp2, visited, end);
                        visited[cl -1][i] = false;
                        break;
                    }
                }
            }
        }

    }

}

class Move {
    int stationNum; // 역 이름
    int subway;     // 호선
    int index;      // 노선 위치
    int direct;     // 지하철 움직이는 방향 (+1, -1) 두가지만 사용
    int count;      // 환승 횟수

    public Move(int stationNum, int subway, int index, int direct, int count) {
        this.stationNum = stationNum;
        this.subway = subway;
        this.index = index;
        this.direct = direct;
        this.count = count;
    }
}